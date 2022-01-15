package com.example.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.User;
import com.example.isa.model.reservations.MansionReservation;

public interface MansionReservationRepository extends JpaRepository<MansionReservation, Long>{

	List<MansionReservation> findAllByUser(User user);
	MansionReservation findById(long id);
}
