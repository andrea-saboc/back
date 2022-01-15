package com.example.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.dto.SearchDTO;
import com.example.isa.model.Mansion;
import com.example.isa.repository.MansionRepository;

@Service
public class MansionFilteringService {
	
	@Autowired
	MansionRepository mansionRepo;
	
	public List<Mansion> getAll() {
		
		return mansionRepo.findAll();
	}
	
	public List<Mansion> searchAll(SearchDTO search) {
		
		if(search.getType().equals("Name")) return SearchByName(search.getValue());
		else if(search.getType().equals("Location")) return SearchByLocation(search.getValue());
		else return searchByGrade(search.getValue());
	}
	
	private List<Mansion> SearchByName(String value) {
		List<Mansion> ret = new ArrayList<Mansion>();
		for(Mansion m: getAll()) {
			if(m.getName().toLowerCase().contains(value.toLowerCase()))
				ret.add(m);
		}
		return ret;
	}
	
	private List<Mansion> SearchByLocation(String value) {
		List<Mansion> ret = new ArrayList<Mansion>();
		for(Mansion m: getAll()) {
			if(m.getAddress().getAddress().toLowerCase().contains(value.toLowerCase()) ||
					m.getAddress().getCity().toLowerCase().contains(value.toLowerCase()) ||
					m.getAddress().getCountry().toLowerCase().contains(value.toLowerCase()))
				ret.add(m);
		}
		return ret;
	}
	
	private List<Mansion> searchByGrade(String value) {
		float f=Float.parseFloat(value);
		List<Mansion> ret = new ArrayList<Mansion>();
		for(Mansion m: getAll()) {
			if(m.getAvgGrade() >= f)
				ret.add(m);
		}
		return ret;
	}


}
