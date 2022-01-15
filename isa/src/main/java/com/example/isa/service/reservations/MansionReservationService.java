package com.example.isa.service.reservations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.isa.dto.ReservationDTO;
import com.example.isa.exceptions.PeriodNoLongerAvailableException;
import com.example.isa.model.MansionAvailablePeriod;
import com.example.isa.model.User;
import com.example.isa.model.reservations.AdditionalService;
import com.example.isa.model.reservations.MansionReservation;
import com.example.isa.model.reservations.ReservationStartEndDateFormatter;
import com.example.isa.repository.AdditionalServiceRepository;
import com.example.isa.repository.MansionAvailablePeriodRepository;
import com.example.isa.repository.MansionRepository;
import com.example.isa.repository.MansionReservationRepository;

@Service
@Transactional(readOnly=true)
public class MansionReservationService {

	@Autowired
	MansionRepository mansionRepo;
	@Autowired 
	MansionReservationRepository mansionReservationRepo;

	@Autowired
	MansionAvailablePeriodRepository availablePeriodsRepo;
	@Autowired
	AdditionalServiceRepository additinalServicesRepo;
	
	@Transactional(readOnly = false)
	public MansionReservation createMansionReservation(ReservationDTO res) throws PeriodNoLongerAvailableException, ParseException {
				
		ReservationStartEndDateFormatter formatter = new ReservationStartEndDateFormatter(res);
		Date startDate = formatter.startDate;
		Date endDate = formatter.endDate;
		
		MansionAvailablePeriod period = availablePeriodsRepo.getPeriodOfInterest(startDate, endDate,res.getEntityId());
		
		if(period == null) {
			throw new PeriodNoLongerAvailableException();}
		
		else {
			
			 MansionReservation newBoatReservation = new MansionReservation(getLoggedUser(),startDate, endDate, res.getNumberOfGuests(),
		    			res.getPrice(), mansionRepo.findById(res.getEntityId()));
		        

		        if(!period.getStartDate().equals(startDate)) {
		        	MansionAvailablePeriod periodBefore = new MansionAvailablePeriod(period.getStartDate(),startDate,period.getMansion());
		        	availablePeriodsRepo.save(periodBefore);
		        }
		        if(!period.getEndDate().equals(endDate)) {
		        	MansionAvailablePeriod periodAfter = new MansionAvailablePeriod(endDate,period.getEndDate(),period.getMansion());
		        	availablePeriodsRepo.save(periodAfter);
		        }
		        
				Set<AdditionalService> services = new HashSet<AdditionalService>();
		        for(long id : res.getAdditionalServices()) {
		        	AdditionalService service = additinalServicesRepo.findById(id).orElse(null);
		        	services.add(service);
		        	newBoatReservation.setTotalPrice( newBoatReservation.getTotalPrice()
		        			+calculateAdditionalServicesPrice(newBoatReservation,res,service));
		        }
		        
		        newBoatReservation.setAdditionalServices(services);
				
		        availablePeriodsRepo.delete(period);
			    return mansionReservationRepo.save(newBoatReservation);			
		}     
	}
	
	
	public double calculateAdditionalServicesPrice(MansionReservation bres,ReservationDTO res,AdditionalService service) {
		
		double initialPrice = bres.getTotalPrice();
		int numberOfWeeks = res.getNumberOfDays() / 7;
		int numberOfDays = res.getNumberOfDays() - 7*numberOfWeeks;
		//dodati i za per week i additinal service
		initialPrice += service.getPricePerHour() * res.getNumberOfHours();
		return initialPrice;
	}

	
	public User getLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}
	
	@Transactional(readOnly = false)
	public MansionReservation cancelMansionReservation(long resId) {
		
		MansionReservation res = mansionReservationRepo.findById(resId);

		MansionAvailablePeriod periodBefore = availablePeriodsRepo.checkIfPeriodHasEndDate(res.getStartDate());
		MansionAvailablePeriod periodAfter = availablePeriodsRepo.checkIfPeriodHasStartDate(res.getEndDate());		
		MansionAvailablePeriod periodToAdd;
		
		if(periodBefore!=null && periodAfter!=null) {
			availablePeriodsRepo.deleteById(periodBefore.getId());
			availablePeriodsRepo.deleteById(periodAfter.getId());
			periodToAdd = new MansionAvailablePeriod(periodBefore.getStartDate(),periodAfter.getEndDate(),res.getMansion());	
		}
		else if (periodBefore==null && periodAfter!=null) {
			availablePeriodsRepo.deleteById(periodAfter.getId());
			periodToAdd = new MansionAvailablePeriod(res.getStartDate(),periodAfter.getEndDate(),res.getMansion());
		}
		else if (periodBefore!=null && periodAfter==null) {
			availablePeriodsRepo.deleteById(periodBefore.getId());
			periodToAdd = new MansionAvailablePeriod(periodBefore.getStartDate(),res.getEndDate(),res.getMansion());
		}
		else 
			periodToAdd = new MansionAvailablePeriod(res.getStartDate(),res.getEndDate(),res.getMansion());
		
		
		availablePeriodsRepo.save(periodToAdd);
		MansionReservation m = mansionReservationRepo.findById(resId);
		m.setCancelled(true);
		mansionReservationRepo.save(m);
		return null;
	}


	public List<MansionReservation> GetMansionReservationHistory() {
		
		Date today = new Date();
		List<MansionReservation> res = new ArrayList<MansionReservation>();
		for(MansionReservation m: mansionReservationRepo.findAllByUser(getLoggedUser())) {
			if(m.getEndDate().before(today) && !m.isCancelled())
				res.add(m);
		}
		return res;
	}
	

}
