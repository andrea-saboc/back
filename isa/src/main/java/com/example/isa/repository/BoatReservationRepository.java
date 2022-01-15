package com.example.isa.repository;

import java.util.Date;
import java.util.List;

import com.example.isa.model.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.isa.model.BoatAvailablePeriod;
import com.example.isa.model.User;
import com.example.isa.model.reservations.BoatReservation;


public interface BoatReservationRepository extends JpaRepository<BoatReservation, Long>{

	List<BoatReservation> findAllByUser(User user);
	BoatReservation findById(long id);
	List<BoatReservation> findAllByBoat(Boat boat);
	
}
