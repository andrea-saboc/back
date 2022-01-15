package com.example.isa.service;
import java.util.*;

import com.example.isa.dto.AddAvailablePeriodDTO;
import com.example.isa.dto.BoatRegistrationDTO;
import com.example.isa.model.*;
import com.example.isa.model.reservations.AdditionalService;
import com.example.isa.model.reservations.BoatReservation;
import com.example.isa.repository.*;
import com.example.isa.service.reservations.BoatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class BoatService {
	@Autowired
	private BoatsRepository boatsRepository;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private BoatOwnerRepository boatOwnerRepository;
	@Autowired
	private BoatAvailablePeriodRepository availablePeriodRepository;
	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;
	@Autowired
	private BoatReservationService boatReservationService;

	public BoatService(BoatsRepository br, ImageRepository ir, BoatOwnerRepository bor, BoatAvailablePeriodRepository apr, AdditionalServiceRepository additionalServiceRepository){
		this.boatsRepository = br;
		this.imageRepository = ir;
		this.boatOwnerRepository = bor;
		this.availablePeriodRepository = apr;
		this.additionalServiceRepository = additionalServiceRepository;
	}

	public List<Boat> getAll() {
		List<Boat> boats = boatsRepository.findAll();
		System.out.println("Service boat getting all");
		System.out.println(boats);
		return boats;
	}

    public Boat registerBoat(BoatRegistrationDTO dto) {
		System.out.println("In registering boat service!");
		Boat newBoat = createBoat(dto);
		newBoat = boatsRepository.save(newBoat);
		Set<AdditionalService> additionalServices = addBoatToServices(dto.additionalServices, newBoat);
		return newBoat;
    }

	private Set<AdditionalService> addBoatToServices(Set<AdditionalService> additionalServices, Boat boat) {
		Set<AdditionalService> additionalServiceWithBoat = new HashSet<>();
		for (AdditionalService as: additionalServices) {
			AdditionalService as1 = as;
			as1.setBoat(boat);
			additionalServiceRepository.save(as1);
			additionalServiceWithBoat.add(as1);
		}
		return additionalServiceWithBoat;
	}

	private Boat createBoat(BoatRegistrationDTO dto) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		BoatOwner boatOwner = boatOwnerRepository.findById(user.getId()).get();
		Address boatAddress = new Address();
		boatAddress.setAddress(dto.address);
		boatAddress.setCity(dto.city);
		boatAddress.setCountry(dto.country);
		boatAddress.setLatitude(dto.latitude);
		boatAddress.setLongitude(dto.longitude);
		Boat newBoat = new Boat();
		newBoat.setBoatOwner(boatOwner);
		//boatOwner.addBoat(newBoat);
		boatOwnerRepository.save(boatOwner);
		newBoat.setName(dto.name);
		newBoat.setPromoDescription(dto.promoDescription);
		newBoat.setType(dto.type);
		newBoat.setLength(dto.length);
		newBoat.setAddress(boatAddress);
		newBoat.setCapacity(dto.capacity);
		newBoat.setFishfinder(dto.fishfinder);
		newBoat.setEnginePower(dto.enginePower);
		newBoat.setNumberOfEngines(dto.numberOfEngines);
		newBoat.setMaxSpeed(dto.maxSpeed);
		newBoat.setRadar(dto.radar);
		newBoat.setGPS(dto.GPS);
		newBoat.setCancellationPolicy(dto.cancellationPolicy);
		newBoat.setVHFradio(dto.VHFradio);
		newBoat.setExteriorImages(convertString2Image(dto.ExteriorImages, newBoat, false));
		newBoat.setInteriorImages(convertString2Image(dto.InteriorImages, newBoat, true));
		newBoat.setRules(convertString2Rule(dto.rules, newBoat));
		newBoat.setPricePerHour(dto.pricePerHour);
		newBoat.setPricePerDay(dto.pricePerDay);
		newBoat.setPriceForSevenDays(dto.priceForSevenDays);
		return newBoat;
	}

	private Set<Image> convertString2Image(Set<String> Images, Boat boat, boolean inter){
		Set<Image> convertedImages = new HashSet<>();
		for (String s: Images) {
			Image newImage = new Image();
			newImage = imageRepository.save(newImage);
			newImage.setImg(s);
			newImage.saveImage();
			convertedImages.add(newImage);
		}
		return convertedImages;
	}

	private Set<Rule> convertString2Rule(Set<String> Rules, Boat boat){
		Set<Rule> convertedRules = new HashSet<>();
		for (String s: Rules){
			Rule newRule = new Rule(s);
			newRule.addBoat(boat);
			convertedRules.add(newRule);
		}
		return convertedRules;
	}

	public Boat getById(Long id) {
		return boatsRepository.findById(id).get();
	}

	public List<Boat> getByOwnerId() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Trying to cast to User:"+ user);
		BoatOwner boatOwner = boatOwnerRepository.findById(user.getId()).get();
		List<Boat> ownersBoats = boatsRepository.findBoatByBoatOwner(boatOwner);
		return ownersBoats;
	}

	public List<BoatAvailablePeriod> getBoatAvailbilities(Long boatId) {
		Boat boat = boatsRepository.findById(boatId).get();
		List<BoatAvailablePeriod> boatAvailability = availablePeriodRepository.findByBoat(boat);
		return boatAvailability;
	}

	public List<BoatAvailablePeriod> addBoatAvailabilities(AddAvailablePeriodDTO dto) {
		Boat boat = boatsRepository.findById(dto.boatId).get();
		BoatAvailablePeriod availablePeriod = new BoatAvailablePeriod(dto.startTime, dto.endTime, boat);
		availablePeriodRepository.save(availablePeriod);
		List<BoatAvailablePeriod> boatNewAvailability = availablePeriodRepository.findByBoat(boat);
		return boatNewAvailability;
	}

    public List<AddAvailablePeriodDTO> getFreeDaysForBoat(Long boatID) {
		List<BoatAvailablePeriod> boatAvailablePeriods = getBoatAvailbilities(boatID);
		List<BoatReservation> boatReservations = boatReservationService.getBoatReservationsByBoat(boatID);
		List<AddAvailablePeriodDTO> availablePeriods = calculateAvailablePeriods(boatAvailablePeriods, boatReservations);
		return availablePeriods;
    }

	private List<AddAvailablePeriodDTO> calculateAvailablePeriods(List<BoatAvailablePeriod> boatAvailablePeriods, List<BoatReservation> boatReservations) {
		List<AddAvailablePeriodDTO> availablePeriods = new ArrayList<>();
		for (BoatAvailablePeriod bap: boatAvailablePeriods) {
			availablePeriods.addAll(calculateAvailablePeriodsFromAp(bap, boatReservations));
		}
		return availablePeriods;
	}

	private List<AddAvailablePeriodDTO> calculateAvailablePeriodsFromAp(BoatAvailablePeriod bap, List<BoatReservation> boatReservations) {
		List<AddAvailablePeriodDTO> availablePeriods = new ArrayList<>();
		List<BoatReservation> overlapedReservations = new ArrayList<>();
		for (BoatReservation br: boatReservations) {
			if ((br.getStartDate().after(bap.getStartDate()) || br.getStartDate().equals(bap.getStartDate()))
					&& (br.getStartDate().before(bap.getEndDate()) || (br.getStartDate().equals(bap.getEndDate())))){
				overlapedReservations.add(br);
				}
			}
		availablePeriods.addAll(separatedAvailablePeriods(sortByAsc(overlapedReservations), bap));
		return availablePeriods;
		}

	private List<AddAvailablePeriodDTO> separatedAvailablePeriods(List<BoatReservation> sortByAsc, BoatAvailablePeriod bap) {
		List<AddAvailablePeriodDTO> availablePeriods = new ArrayList<>();
		AddAvailablePeriodDTO right = new AddAvailablePeriodDTO(bap.getStartDate(), bap.getEndDate(), bap.getBoat().getId());
		for (BoatReservation br : sortByAsc){
			if (!br.getStartDate().equals(right.startTime)){
				availablePeriods.add(new AddAvailablePeriodDTO(right.startTime, br.getStartDate(), right.boatId));
			}
			right.startTime = br.getEndDate();
		}
		if (!right.startTime.equals(right.endTime)){
			availablePeriods.add(right);
		}
		return availablePeriods;
	}

	private List<BoatReservation> sortByAsc(List<BoatReservation> overlapedReservations) {
		for(int i=0; i<overlapedReservations.size(); i++){
			for(int j = i+1; j<overlapedReservations.size(); j++){
				if (overlapedReservations.get(i).getStartDate().before(overlapedReservations.get(j).getStartDate())){
					BoatReservation temp = overlapedReservations.get(i);
					overlapedReservations.set(i, overlapedReservations.get(j));
					overlapedReservations.set(j, temp);
				}

			}
		}
		return overlapedReservations;
	}


}
