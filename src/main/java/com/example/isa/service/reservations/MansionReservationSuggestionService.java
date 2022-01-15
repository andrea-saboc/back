package com.example.isa.service.reservations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.isa.dto.PotentialMansionReservationDTO;
import com.example.isa.dto.ReservationSearchDTO;
import com.example.isa.model.Boat;
import com.example.isa.model.Mansion;
import com.example.isa.model.MansionAvailablePeriod;
import com.example.isa.model.reservations.AdditionalService;
import com.example.isa.repository.AdditionalServiceRepository;
import com.example.isa.repository.MansionAvailablePeriodRepository;
import com.example.isa.repository.MansionRepository;
import com.example.isa.repository.MansionReservationRepository;

@Service
@Transactional(readOnly=true)
public class MansionReservationSuggestionService {

	@Autowired 
	MansionReservationRepository mansionReservationRepo;
	@Autowired
	MansionRepository mansionRepo;
	@Autowired
	MansionAvailablePeriodRepository availablePeriodsRepo;
	@Autowired
	AdditionalServiceRepository additinalServicesRepo;
	
	public List<PotentialMansionReservationDTO> getAvailableMansions(ReservationSearchDTO formParams) {
		String sDate = formParams.getStartDate()+" "+formParams.getStartTime();
		System.out.println(sDate);	
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try {
			Date startDate=formatter.parse(sDate);
			
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(startDate);
	        cal.add(Calendar.DAY_OF_MONTH, formParams.getNumberOfDays());

	        Date endDate = cal.getTime();
	        System.out.println("Adding days to start date: "+endDate);
	        
	        List<Mansion> mansions = FilterByLocationAndAvgGrade(formParams.getLocation(),
	        		formParams.getGrade(),getAvailableMansionsBetweenDates(startDate,endDate));
		    return createPotentialReservations(mansions,formParams);
		    
			} catch (ParseException e) {
			System.out.println("PUČE!");
			e.printStackTrace();
			}
				
		return null;
		}
		
		public List<PotentialMansionReservationDTO> createPotentialReservations(List<Mansion> mansions,ReservationSearchDTO formParams){

			List<PotentialMansionReservationDTO> ret = new ArrayList<PotentialMansionReservationDTO>();
			for(Mansion m : mansions) {
				
				List<String> services = new ArrayList<String>();
				List<Long> servicesId = new ArrayList<Long>();
				
				for(AdditionalService a: additinalServicesRepo.findAllByMansion(m)) {
					
					String serviceInfo = a.getName() + " ( Price per day: "+a.getPricePerDay()+" ).";
					services.add(serviceInfo);
					servicesId.add(a.getId());
				}
				
				ret.add(new PotentialMansionReservationDTO(m.getId(), m.getName(), m.getPromoDescription(), m.getAvgGrade(),
						m.getPricePerDay(), m.getPriceForSevenDays(), calculateReservationPrice(formParams,m),services,servicesId));
			}
			return ret;
		}
	
		public double calculateReservationPrice(ReservationSearchDTO formParams,Mansion mansion) {
			
			double price = 0.00;
			int numberOfWeeks = formParams.getNumberOfDays()/7;
			int numberOfDays = formParams.getNumberOfDays() - numberOfWeeks * 7;
			price += numberOfWeeks * mansion.getPriceForSevenDays();
			price += numberOfDays * mansion.getPricePerDay();
			
			return price;
		}
		
	public List<Mansion> FilterByLocationAndAvgGrade(String location, float avgGrade,List<Mansion> boats){
		
		List<Mansion> ret = new ArrayList<Mansion>();
		for(Mansion b : boats) {
			if((b.getAddress().getAddress().contains(location) || b.getAddress().getCity().contains(location)) && b.getAvgGrade()>= avgGrade)
				ret.add(b);
			
		}
		
		return ret;
		
	}
	public List<Mansion> getAvailableMansionsBetweenDates(Date startDate, Date endDate){
		
		List<Mansion> ret = new ArrayList<Mansion>();
		
		for(MansionAvailablePeriod p: availablePeriodsRepo.findAll()) {
			
			if(isDateInBetweenIncludingEndPoints(p.getStartDate(),p.getEndDate(),startDate) &&
					isDateInBetweenIncludingEndPoints(p.getStartDate(),p.getEndDate(),endDate) &&
					!ret.contains(p.getMansion()))
				
				ret.add(p.getMansion());
		}
		return ret;
	}
	
	public static boolean isDateInBetweenIncludingEndPoints(final Date min, final Date max, final Date date){
	    return !(date.before(min) || date.after(max));
	}


	
	
}
