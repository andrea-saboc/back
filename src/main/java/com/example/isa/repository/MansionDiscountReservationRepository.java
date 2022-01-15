package com.example.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Mansion;
import com.example.isa.model.User;
import com.example.isa.model.reservations.MansionDiscountReservation;

public interface MansionDiscountReservationRepository extends JpaRepository<MansionDiscountReservation,Long>{

	List<MansionDiscountReservation> findAllByMansion(Mansion mansion);
	List<MansionDiscountReservation> findAllByMansionAndReservedFalse(Mansion b);
	List<MansionDiscountReservation> findAllByUserAndCancelledFalseAndReservedTrue(User u);

}
