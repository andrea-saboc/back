package com.example.isa;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.isa.model.Boat;
import com.example.isa.model.Mansion;
import com.example.isa.model.MansionAvailablePeriod;
import com.example.isa.model.reservations.BoatDiscountReservation;
import com.example.isa.repository.AdditionalServiceRepository;
import com.example.isa.repository.AddressRepository;
import com.example.isa.repository.BoatAvailablePeriodRepository;
import com.example.isa.repository.BoatDiscountReservationRepository;
import com.example.isa.repository.BoatOwnerRepository;
import com.example.isa.repository.BoatRepository;
import com.example.isa.repository.BoatReservationRepository;
import com.example.isa.repository.MansionAvailablePeriodRepository;
import com.example.isa.repository.MansionRepository;
import com.example.isa.repository.UserRepository;
import com.example.isa.service.AdventureService;


@SpringBootApplication
public class IsaApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	AdventureService as;

	@Autowired
	BoatOwnerRepository boatOwnerRepository;
	
	@Autowired
	BoatReservationRepository repo;
	@Autowired
	BoatRepository boatRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	BoatAvailablePeriodRepository periodRepo;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	AdditionalServiceRepository additionalServiceRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	MansionAvailablePeriodRepository mperiodRepo;
	@Autowired
	MansionRepository mrepo;
	
	@Autowired
	BoatDiscountReservationRepository resRepo;
    
	public static void main(String[] args) {
		SpringApplication.run(IsaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		
		Mansion m = mrepo.findById(1);
		Mansion m1 = mrepo.findById(2);
		
		MansionAvailablePeriod a11 = new MansionAvailablePeriod(new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime(),new GregorianCalendar(2022, Calendar.JANUARY, 10).getTime(),m);
		MansionAvailablePeriod a22 = new MansionAvailablePeriod(new GregorianCalendar(2022, Calendar.JANUARY, 20).getTime(),new GregorianCalendar(2022, Calendar.JANUARY, 28).getTime(),m);
		MansionAvailablePeriod a33 = new MansionAvailablePeriod(new GregorianCalendar(2022, Calendar.MARCH, 1).getTime(),new GregorianCalendar(2022, Calendar.MARCH, 16).getTime(),m);
		MansionAvailablePeriod a44 = new MansionAvailablePeriod(new GregorianCalendar(2022, Calendar.JUNE, 1).getTime(),new GregorianCalendar(2022, Calendar.JUNE, 21).getTime(),m);
		
		
		MansionAvailablePeriod a111 = new MansionAvailablePeriod(new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime(),new GregorianCalendar(2022, Calendar.JANUARY, 10).getTime(),m1);
		MansionAvailablePeriod a221 = new MansionAvailablePeriod(new GregorianCalendar(2022, Calendar.JANUARY, 20).getTime(),new GregorianCalendar(2022, Calendar.JANUARY, 28).getTime(),m1);
		MansionAvailablePeriod a331 = new MansionAvailablePeriod(new GregorianCalendar(2022, Calendar.MARCH, 1).getTime(),new GregorianCalendar(2022, Calendar.MARCH, 16).getTime(),m1);
		MansionAvailablePeriod a441 = new MansionAvailablePeriod(new GregorianCalendar(2022, Calendar.JUNE, 1).getTime(),new GregorianCalendar(2022, Calendar.JUNE, 21).getTime(),m1);
				
		mperiodRepo.save(a111);
		mperiodRepo.save(a221);		
		mperiodRepo.save(a331);		
		mperiodRepo.save(a441);		
		
		
		
		mperiodRepo.save(a11);
		mperiodRepo.save(a22);		
		mperiodRepo.save(a33);		
		mperiodRepo.save(a44);

		Boat b = boatRepo.findByName("Milicija");
		
		resRepo.save(new BoatDiscountReservation(new Date(), new Date(), 8,200, b));
		resRepo.save(new BoatDiscountReservation(new Date(), new Date(), 6,120, b));			
		resRepo.save(new BoatDiscountReservation(new Date(), new Date(), 6,189, b));	
		
		System.out.println("Reservacije od Milicije: ");
		
		List<BoatDiscountReservation> re = resRepo.findAllByBoat(b);
		for(BoatDiscountReservation r: re ) {
			System.out.println(r.getPriceWithDiscount());
		}
		

		/*
		Boat b = boatRepo.findByName("Milicija");
		

		Client c = new Client("Igor","Stojanovic", "Address", "City", "Serbiania", "468438",
				"littlevamp999@gmail.com", "igi", 0,0);
		c.setPassword(passwordEncoder.encode("igi"));
		userRepo.save(c);
		
		//repo.save(new BoatReservation(c, new Date(), 66, 77, b1));
		//repo.save(new BoatReservation(c, new Date(), 4444, 77, b2));

		
    	Iterable<BoatReservation> res = repo.findAllByUser(c);
    	
    	for(BoatReservation r: res){
    		System.out.println(r.getBoat().getName());
    	}
    	*/

	}
	


}
