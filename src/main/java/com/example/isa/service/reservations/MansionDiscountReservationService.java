package com.example.isa.service.reservations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.isa.model.Mansion;
import com.example.isa.model.User;
import com.example.isa.model.reservations.MansionDiscountReservation;
import com.example.isa.repository.MansionDiscountReservationRepository;
import com.example.isa.repository.MansionRepository;

public class MansionDiscountReservationService {
	
	@Autowired
	MansionDiscountReservationRepository reservationRepo;
	@Autowired
	MansionRepository mansionRepo;
	
    public List<MansionDiscountReservation> getBoatDiscountReservations(long id) {

    	Mansion mansion = mansionRepo.findById(id);
		return reservationRepo.findAllByMansion(mansion);
    }
    
    public MansionDiscountReservation makeBoatReservationOnDiscount(long resId) throws Exception {
    	
    	MansionDiscountReservation res = reservationRepo.findById(resId).orElse(new MansionDiscountReservation());
    	if(res == null) throw new Exception();
    	else {
    	res.setReserved(true);
    	res.setUser(getLoggedUser());
    	return reservationRepo.save(res);
    	}
    }
	
    public User getLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	return user;
    }
}
