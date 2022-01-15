package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Authority;

public interface RoleRepository extends JpaRepository<Authority, Long> {
	
	Authority findByName(String name);
}
