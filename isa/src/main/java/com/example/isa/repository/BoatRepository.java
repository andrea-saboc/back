package com.example.isa.repository;



import com.example.isa.model.BoatOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Boat;

import java.util.List;

public interface BoatRepository extends JpaRepository<Boat, Long>{

	Boat findByName(String name);
	List<Boat> findBoatByBoatOwner(BoatOwner boatOwner);
}
