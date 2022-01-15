package com.example.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.dto.ClientComplaintDTO;
import com.example.isa.mail.MailService;
import com.example.isa.model.Boat;
import com.example.isa.model.Complaint;
import com.example.isa.model.Mansion;
import com.example.isa.service.ClientComplaintService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ComplaintController {
	
	@Autowired
	ClientComplaintService complaintService;
	
	@Autowired
	private MailService<String> mailService;
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/complaints/addBoatComplain",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBoatComplaint(@RequestBody ClientComplaintDTO dto) throws JsonProcessingException{	
		
		Complaint c = complaintService.addBoatComplaint(dto);
		mailService.sendMansionComplaintEmail(c);
		return ResponseEntity.ok("Your complaint has been submited!");
	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/complaints/addBoatOwnerComplain",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBoatOwnerComplaint(@RequestBody ClientComplaintDTO dto) throws JsonProcessingException{	
		
		Complaint c = complaintService.addAdvertiserComplaint(dto);
		mailService.sendBoatOwnerComplaintEmail(c);
		return ResponseEntity.ok("Your complaint has been submited!");
	}
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/complaints/addMansionComplain",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addMansionComplaint(@RequestBody ClientComplaintDTO dto) throws JsonProcessingException{	
		
		Complaint c = complaintService.addMansionComplaint(dto);
		mailService.sendMansionComplaintEmail(c);
		return ResponseEntity.ok("Your complaint has been submited!");
	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/complaints/addMansionOwnerComplain",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addMansionOwnerComplaint(@RequestBody ClientComplaintDTO dto) throws JsonProcessingException{	
		
		Complaint c = complaintService.addAdvertiserComplaint(dto);
		mailService.sendMansionOwnerComplaintEmail(c);
		return ResponseEntity.ok("Your complaint has been submited!");
	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.GET, value = "/complaints/boats",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Boat>> complainBoats() throws JsonProcessingException{	
		
		return ResponseEntity.ok(complaintService.getBoats());
	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.GET, value = "/complaints/mansions",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Mansion>> complainMansions() throws JsonProcessingException{	
		
		return ResponseEntity.ok(complaintService.getMansions());
	}

}
