package com.example.isa.repository;

import com.example.isa.model.BoatOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertiserRepository extends JpaRepository<BoatOwner, Long> {
}
