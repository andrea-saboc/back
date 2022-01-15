package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.isa.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	Client findByEmail(String email);
	Client findByActivationCode(String code);
	Client findByBlockedAndActivationCode(boolean blocked,String code);
}
