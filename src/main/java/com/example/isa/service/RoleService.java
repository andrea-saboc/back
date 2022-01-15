package com.example.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repo;
	
}
