package com.example.isa.service.reservations;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import com.example.isa.dto.MakeBoatReservationForClientDTO;
import com.example.isa.model.*;
import com.example.isa.model.reservations.AdditionalService;
import com.example.isa.model.reservations.BoatReservation;
import com.example.isa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.isa.dto.ReservationDTO;
import com.example.isa.exceptions.PeriodNoLongerAvailableException;
import com.example.isa.model.Boat;
import com.example.isa.model.BoatAvailablePeriod;
import com.example.isa.model.BoatOwner;
import com.example.isa.model.User;
import com.example.isa.model.reservations.AdditionalService;
import com.example.isa.model.reservations.BoatReservation;
import com.example.isa.model.reservations.ReservationStartEndDateFormatter;
import com.example.isa.repository.AdditionalServiceRepository;
import com.example.isa.repository.BoatAvailablePeriodRepository;
import com.example.isa.repository.BoatOwnerRepository;
import com.example.isa.repository.BoatRepository;
import com.example.isa.repository.BoatReservationRepository;

@Service
//@Transactional(readOnly=true)
public class BoatReservationService {

	@Autowired 
	BoatReservationRepository boatReservationRepo;
	@Autowired
	BoatRepository boatRepo;
	@Autowired
	BoatAvailablePeriodRepository availablePeriodsRepo;
	@Autowired
	AdditionalServiceRepository additinalServicesRepo;
	@Autowired
	BoatOwnerRepository boatOwnerRepository;
	@Autowired
	ClientRepository clientRepository;
	
	//@Transactional(readOnly = false)
	public BoatReservation createBoatReservation(ReservationDTO res) throws ParseException, PeriodNoLongerAvailableException {
		
		
		ReservationStartEndDateFormatter formatter = new ReservationStartEndDateFormatter(res);
		Date startDate = formatter.startDate;
		Date endDate = formatter.endDate;

        
        BoatAvailablePeriod period = availablePeriodsRepo.getPeriodOfInterest(startDate, startDate,res.getEntityId());
        
        if(period == null) {
        	throw new PeriodNoLongerAvailableException();
        	
        }
        else {
	        BoatReservation newBoatReservation = new BoatReservation(getLoggedUser(), startDate,endDate, res.getNumberOfGuests(), res.getPrice(),
					boatRepo.findById(res.getEntityId()).orElse(new Boat()));
	        
	        if(!period.getStartDate().equals(startDate)) {
	        	BoatAvailablePeriod periodBefore = new BoatAvailablePeriod(period.getStartDate(),startDate,period.getBoat());
	        	availablePeriodsRepo.save(periodBefore);
	        }
	        if(!period.getEndDate().equals(endDate)) {
	        	BoatAvailablePeriod periodAfter = new BoatAvailablePeriod(endDate,period.getEndDate(),period.getBoat());
	        	availablePeriodsRepo.save(periodAfter);
	        }
	        
	        Set<AdditionalService> services = new HashSet<AdditionalService>();
	        for(long id : res.getAdditionalServices()) {
	        	AdditionalService service = additinalServicesRepo.findById(id).orElse(null);
	        	services.add(service);
	        	newBoatReservation.setTotalPrice( newBoatReservation.getTotalPrice()
	        			+calculateAdditionalServicesPrice(newBoatReservation,res,service));
	        }
	        
	        availablePeriodsRepo.delete(period);
	        newBoatReservation.setAdditionalServices(services);
	            
		    return boatReservationRepo.save(newBoatReservation);
        }
	}
	
	public double calculateAdditionalServicesPrice(BoatReservation bres,ReservationDTO res,AdditionalService service) {
		
		double initialPrice = bres.getTotalPrice();
		initialPrice += service.getPricePerDay() * res.getNumberOfDays();
		initialPrice += service.getPricePerHour() * res.getNumberOfHours();
		return initialPrice;
	}

	
	public User getLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}
	
	//@Transactional(readOnly = false)
	public BoatReservation cancelBoatReservation(long resId) {
		
		BoatReservation res = boatReservationRepo.findById(resId);

		BoatAvailablePeriod periodBefore = availablePeriodsRepo.checkIfPeriodHasEndDate(res.getStartDate());
		BoatAvailablePeriod periodAfter = availablePeriodsRepo.checkIfPeriodHasStartDate(res.getEndDate());		
		BoatAvailablePeriod periodToAdd;
		
		if(periodBefore!=null && periodAfter!=null) {
			availablePeriodsRepo.deleteById(periodBefore.getId());
			availablePeriodsRepo.deleteById(periodAfter.getId());
			periodToAdd = new BoatAvailablePeriod(periodBefore.getStartDate(),periodAfter.getEndDate(),res.getBoat());	
		}
		else if (periodBefore==null && periodAfter!=null) {
			availablePeriodsRepo.deleteById(periodAfter.getId());
			periodToAdd = new BoatAvailablePeriod(res.getStartDate(),periodAfter.getEndDate(),res.getBoat());
		}
		else if (periodBefore!=null && periodAfter==null) {
			availablePeriodsRepo.deleteById(periodBefore.getId());
			periodToAdd = new BoatAvailablePeriod(periodBefore.getStartDate(),res.getEndDate(),res.getBoat());
		}
		else 
			periodToAdd = new BoatAvailablePeriod(res.getStartDate(),res.getEndDate(),res.getBoat());
		
		
		availablePeriodsRepo.save(periodToAdd);
		BoatReservation b = boatReservationRepo.findById(resId);
		b.setCancelled(true);
		boatReservationRepo.save(b);
		return null;
	}
	
	public List<BoatReservation> GetBoatReservationHistory(){
		
		Date today = new Date();
		List<BoatReservation> res = new ArrayList<BoatReservation>();
		for(BoatReservation m: boatReservationRepo.findAllByUser(getLoggedUser())) {
			if(m.getEndDate().before(today) && !m.isCancelled())
				res.add(m);
		}
		System.out.println("KOLIKO IMA BOATS "+res.size());
		return res;
		
		//return boatReservationRepo.findAllByUser(getLoggedUser());

	}
    public List<BoatReservation> getLoggedUserReservations() {
		User user = getLoggedUser();
		BoatOwner boatOwner = boatOwnerRepository.findById(user.getId()).get();
		List<Boat> ownersBoats = boatRepo.findBoatByBoatOwner(boatOwner);
		List<BoatReservation> boatReservations = new ArrayList<>();
		for ( Boat boat : ownersBoats) {
			boatReservations.addAll(boatReservationRepo.findAllByBoat(boat));
		}
		return boatReservations;
    }

	public List<BoatReservation> getBoatReservationsByBoat(Long boatId) {
		Boat boat = boatRepo.findById(boatId).get();
		List<BoatReservation> boatReservations = boatReservationRepo.findAllByBoat(boat);
		return boatReservations;
	}

    public boolean createBoatReservationForClient(MakeBoatReservationForClientDTO dto) {
		if(valid(dto)){
			Client client = clientRepository.findByEmail(dto.email);
			Boat boat = boatRepo.findById(dto.boatId).get();
			BoatReservation boatReservation = new BoatReservation();
			boatReservation.setBoat(boat);
			boatReservation.setUser(client);
			boatReservation.setAdditionalServices(dto.additionalServiceSet);
			boatReservation.setStartDate(dto.startDate);
			boatReservation.setEndDate(dto.endDate);
			boatReservation.setCancelled(false);
			boatReservation.setNumberOfGuests(dto.numberOfGuests);
			boatReservation.setType("BOAT");
			boatReservation.setTotalPrice(calculateFinalPrice(boat, dto));
			boatReservationRepo.save(boatReservation);
			return true;
		}
		else return false;
    }

	private double calculateFinalPrice(Boat boat, MakeBoatReservationForClientDTO dto) {
		double finalPrice = 0;
		Long diff = dto.endDate.getTime() - dto.startDate.getTime();
		Long hours = TimeUnit.HOURS.toHours(diff);
		Long days = TimeUnit.DAYS.toDays(diff);
		if(days > 4){
			finalPrice += boat.getPriceForSevenDays();
			for (AdditionalService as : dto.additionalServiceSet){
				finalPrice+=days* as.getPricePerDay();
			}
		}
		else if(hours > 5){
			finalPrice += boat.getPricePerDay();
			for (AdditionalService as : dto.additionalServiceSet){
				finalPrice+= as.getPricePerDay();
			}
		} else{
			finalPrice += hours * boat.getPricePerHour();
			for (AdditionalService as : dto.additionalServiceSet){
				finalPrice+= as.getPricePerHour();
			}
		}
		return finalPrice;
	}

	private boolean valid(MakeBoatReservationForClientDTO dto) {
		boolean valid = true;
		if(dto.startDate.after(dto.endDate)) valid = false;
		if(boatNotAvailable(dto)) valid = false;
		return valid;
	}

	private boolean boatNotAvailable(MakeBoatReservationForClientDTO dto) {
		boolean available = true;
		Boat boat = boatRepo.findById(dto.boatId).get();
		List<BoatAvailablePeriod> boatAvailablePeriods = availablePeriodsRepo.findByBoat(boat);
		if(notOverlaps(boatAvailablePeriods, dto)){
			available = false;
			System.out.println("The boat is not available at that time!");
		} else if(anotherReservationOverlaps(boat, dto)){
			available = false;
			System.out.println("There is another reservation in that period!");
		}
		return available;

	}

	private boolean anotherReservationOverlaps(Boat boat, MakeBoatReservationForClientDTO dto) {
		boolean overlaps = false;
		List<BoatReservation> boatReservations = boatReservationRepo.findAllByBoat(boat);
		for (BoatReservation boatReservation : boatReservations){
			if(((boatReservation.getStartDate().after(dto.startDate) || boatReservation.getStartDate().equals(dto.startDate))
					&& (dto.startDate.before(boatReservation.getEndDate())))
					||
					(dto.endDate.after(boatReservation.getStartDate())
					&& (dto.endDate.before(boatReservation.getEndDate()) || dto.endDate.equals(boatReservation.getEndDate())))
			)	{
				overlaps = true;
				break;
			}
		}
		return overlaps;
	}

	private boolean notOverlaps(List<BoatAvailablePeriod> boatAvailablePeriods, MakeBoatReservationForClientDTO dto) {
		boolean overlaps = false;
		for(BoatAvailablePeriod boatAvailablePeriod : boatAvailablePeriods){
			if((dto.startDate.after(boatAvailablePeriod.getStartDate()) || dto.startDate.equals(boatAvailablePeriod.getStartDate()))
			&& dto.startDate.before(boatAvailablePeriod.getEndDate())
			&& (dto.endDate.before(boatAvailablePeriod.getEndDate()) || dto.endDate.equals(boatAvailablePeriod.getEndDate()))
			&& dto.endDate.after(boatAvailablePeriod.getStartDate())){
				overlaps=true;
				break;
			}
		}
		return !overlaps;
	}


}
