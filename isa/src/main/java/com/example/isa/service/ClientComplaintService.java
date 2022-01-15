package com.example.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.isa.dto.ClientComplaintDTO;
import com.example.isa.model.AdvertiserComplaint;
import com.example.isa.model.Boat;
import com.example.isa.model.BoatComplaint;
import com.example.isa.model.Complaint;
import com.example.isa.model.Mansion;
import com.example.isa.model.MansionComplaint;
import com.example.isa.model.User;
import com.example.isa.model.reservations.BoatReservation;
import com.example.isa.model.reservations.MansionReservation;
import com.example.isa.repository.BoatRepository;
import com.example.isa.repository.BoatReservationRepository;
import com.example.isa.repository.ClientRepository;
import com.example.isa.repository.ComplaintRepository;
import com.example.isa.repository.MansionRepository;
import com.example.isa.repository.MansionReservationRepository;

@Service
public class ClientComplaintService {
	
	@Autowired
	ComplaintRepository complaintRepository;
	@Autowired
	BoatRepository boatRepository;
	@Autowired
	MansionRepository mansionRepository;
	@Autowired
	ClientRepository clientRepo;
	@Autowired
	BoatReservationRepository boatReservationRepo;
	@Autowired
	MansionReservationRepository mansionReservationRepo;

	public Complaint addBoatComplaint(ClientComplaintDTO dto) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return complaintRepository.save(new BoatComplaint(clientRepo.findByEmail(user.getEmail()), dto.getContent(),boatRepository.findById(dto.getEntityId()).orElse(new Boat())));
	}
	public Complaint addAdvertiserComplaint(ClientComplaintDTO dto) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return complaintRepository.save(new AdvertiserComplaint(clientRepo.findByEmail(user.getEmail()), dto.getContent(),user));
	}
	public Complaint addMansionComplaint(ClientComplaintDTO dto) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return complaintRepository.save(new MansionComplaint(clientRepo.findByEmail(user.getEmail()), dto.getContent(),mansionRepository.findById(dto.getEntityId())));
	
	}
	public List<Boat> getBoats() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Boat> ret = new ArrayList<Boat>();
		for(BoatReservation b : boatReservationRepo.findAllByUser(user)) {
			if(!ret.contains(b.getBoat()))
				ret.add(b.getBoat());			
		}		
		return ret;
	}
	public List<Mansion> getMansions() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Mansion> ret = new ArrayList<Mansion>();
		for(MansionReservation b : mansionReservationRepo.findAllByUser(user)) {
			if(!ret.contains(b.getMansion()))
				ret.add(b.getMansion());			
		}		
		return ret;
	}

}
