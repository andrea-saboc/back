package com.example.isa.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.isa.constants.FeedbackConstants;
import com.example.isa.model.ClientFeedback;
import com.example.isa.model.User;
import com.example.isa.model.reservations.BoatReservation;
import com.example.isa.repository.BoatRepository;
import com.example.isa.repository.BoatReservationRepository;
import com.example.isa.repository.ClientFeedbackRepository;

public class FeedbackServiceTest {
	
	@Mock
	ClientFeedbackRepository feedbackRepository;
	
	@Mock
	BoatRepository boatRepository;
	
	@Mock
	BoatReservationRepository boatReservationRepo;
	
	@Mock
	private BoatReservation boatReservation;
	
	@Mock
	private User user;
	
	@InjectMocks
	private ClientFeedbackService service;
	
	@Test
	public void CheckFeedback() {
		
		//when(boatReservationRepo.findById(0)).thenReturn(boatReservation);
		when(service.getLoggedUser()).thenReturn(user);
		
		ClientFeedback feedback = service.addBoatFeedback(FeedbackConstants.FEEDBACK);

		assertTrue(feedback != null);
	}
	
}
