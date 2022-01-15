package com.example.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.isa.dto.ClientFeedbackDTO;
import com.example.isa.model.ClientFeedback;
import com.example.isa.model.User;
import com.example.isa.model.reservations.BoatReservation;
import com.example.isa.model.reservations.MansionReservation;
import com.example.isa.repository.BoatReservationRepository;
import com.example.isa.repository.ClientFeedbackRepository;
import com.example.isa.repository.MansionReservationRepository;

@Service
public class ClientFeedbackService {
	
	@Autowired
	ClientFeedbackRepository feedbackRepo;
	@Autowired
	BoatReservationRepository boatReservationRepo;
	@Autowired
	MansionReservationRepository mansionReservationRepo;


	public ClientFeedback addBoatOwnerFeedback(ClientFeedbackDTO dto) {
		
		ClientFeedback feedback = new ClientFeedback(dto.getContent(), dto.getGrade(),getLoggedUser().getEmail());
		feedbackRepo.save(feedback);
		BoatReservation boatReservation = boatReservationRepo.findById(dto.getReservation());
		boatReservation.setBoatOwnerFeedback(feedback);
		boatReservationRepo.save(boatReservation);
		return feedback;		
	}
	
	public ClientFeedback addBoatFeedback(ClientFeedbackDTO dto) {
		
		ClientFeedback feedback = new ClientFeedback(dto.getContent(), dto.getGrade(),getLoggedUser().getEmail());
		feedbackRepo.save(feedback);
		BoatReservation boatReservation = boatReservationRepo.findById(dto.getReservation());
		boatReservation.setBoatFeedback(feedback);
		boatReservationRepo.save(boatReservation);
		return feedback;		
	}
	
	public ClientFeedback addMansionOwnerFeedback(ClientFeedbackDTO dto) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ClientFeedback feedback = new ClientFeedback(dto.getContent(), dto.getGrade(),user.getEmail());
		feedbackRepo.save(feedback);
		MansionReservation mansionReservation = mansionReservationRepo.findById(dto.getReservation());
		mansionReservation.setMansionOwnerFeedback(feedback);
		mansionReservationRepo.save(mansionReservation);
		return feedback;		
	}
	
	public ClientFeedback addMansionFeedback(ClientFeedbackDTO dto) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ClientFeedback feedback = new ClientFeedback(dto.getContent(), dto.getGrade(),user.getEmail());
		feedbackRepo.save(feedback);
		MansionReservation mansionReservation = mansionReservationRepo.findById(dto.getReservation());
		mansionReservation.setMansionFeedback(feedback);
		mansionReservationRepo.save(mansionReservation);
		return feedback;		
	}
	
	public User getLoggedUser() {		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}	
	

}
