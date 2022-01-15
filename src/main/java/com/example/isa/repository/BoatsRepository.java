package com.example.isa.repository;

import com.example.isa.model.Boat;
import com.example.isa.model.BoatOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoatsRepository extends JpaRepository<Boat, Long> {
    Boat findByName(String name);
    List<Boat> findBoatByBoatOwner(BoatOwner boatOwner);
}
