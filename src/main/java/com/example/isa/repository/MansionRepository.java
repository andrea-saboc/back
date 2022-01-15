package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Mansion;


public interface MansionRepository extends JpaRepository<Mansion, Long> {

	Mansion findById(long id);
}
