package com.example.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.dto.ClientFeedbackDTO;
import com.example.isa.model.ClientFeedback;
import com.example.isa.service.ClientFeedbackService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class FeedbackController {
	
	@Autowired
	ClientFeedbackService feedbackService;
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/feedbacks/addBoatOwnerFeedback",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientFeedback> addBoatOwnerFeedback(@RequestBody ClientFeedbackDTO dto) throws JsonProcessingException{	
		
		return ResponseEntity.ok(feedbackService.addBoatOwnerFeedback(dto));
	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/feedbacks/addBoatFeedback",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientFeedback> addBoatFeedback(@RequestBody ClientFeedbackDTO dto) throws JsonProcessingException{	
		
		return ResponseEntity.ok(feedbackService.addBoatFeedback(dto));
	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/feedbacks/addMansionOwnerFeedback",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientFeedback> addMansionOwnerFeedback(@RequestBody ClientFeedbackDTO dto) throws JsonProcessingException{	
		
		return ResponseEntity.ok(feedbackService.addMansionOwnerFeedback(dto));
	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/feedbacks/addMansionFeedback",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientFeedback> addMansionFeedback(@RequestBody ClientFeedbackDTO dto) throws JsonProcessingException{	
		
		return ResponseEntity.ok(feedbackService.addMansionFeedback(dto));
	}

}
