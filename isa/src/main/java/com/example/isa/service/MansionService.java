package com.example.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.dto.SearchDTO;
import com.example.isa.model.Mansion;
import com.example.isa.repository.MansionRepository;

@Service
public class MansionService {
	
	@Autowired
	MansionRepository mansionRepo;
	
	public List<Mansion> getAll() {
		
		return mansionRepo.findAll();
	}
	


}
