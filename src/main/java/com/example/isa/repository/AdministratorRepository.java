package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Administrator;
import com.example.isa.model.FishingInstructor;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

}
