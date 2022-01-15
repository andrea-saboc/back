package com.example.isa.controller;

import java.text.ParseException;
import java.util.List;

import com.example.isa.dto.*;
import com.example.isa.model.Boat;
import javax.mail.MessagingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.dto.ActiveReservationDTO;
import com.example.isa.dto.PotentialBoatReservationDTO;
import com.example.isa.dto.PotentialMansionReservationDTO;
import com.example.isa.dto.ReservationDTO;
import com.example.isa.dto.ReservationSearchDTO;
import com.example.isa.exceptions.PeriodNoLongerAvailableException;
import com.example.isa.mail.MailService;
import com.example.isa.model.reservations.BoatReservation;
import com.example.isa.model.reservations.MansionReservation;
import com.example.isa.service.reservations.BoatReservationService;
import com.example.isa.service.reservations.BoatReservationSuggestionService;
import com.example.isa.service.reservations.MansionReservationService;
import com.example.isa.service.reservations.MansionReservationSuggestionService;
import com.example.isa.service.reservations.ReservationService;



@RestController
public class ClientReservationController {
	
	@Autowired 
	BoatReservationService boatResService;
	@Autowired 
	MansionReservationService mansionResService;
	

	@Autowired
	BoatReservationSuggestionService boatSuggestionService;
	@Autowired
	MansionReservationSuggestionService mansionSuggestionService;
	
	@Autowired
	ReservationService reservationService;
	@Autowired
	private MailService<String> mailService;
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
    @RequestMapping(method = RequestMethod.GET,value = "/reservations/boats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BoatReservation>> getBoatReservations(){
    	
    	System.out.println("TRAZI SE BOATS");
    	try {
            return new ResponseEntity<>(boatResService.GetBoatReservationHistory(), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
	@PreAuthorize("hasRole('ROLE_CLIENT')")
    @RequestMapping(method = RequestMethod.GET,value = "/reservations/mansions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MansionReservation>> getMansionReservations(){

        try {
            return new ResponseEntity<>(mansionResService.GetMansionReservationHistory(), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
    @RequestMapping(method = RequestMethod.GET,value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ActiveReservationDTO>> getUserReservations(){
    	
		System.out.println("Geting all reservations for user");
        try {
            return new ResponseEntity<>(reservationService.getActiveReservations(), HttpStatus.OK);
        } catch (Exception e){
        	System.out.println(e);
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
	@PreAuthorize("hasRole('ROLE_CLIENT')")
    @RequestMapping(method = RequestMethod.POST,value = "/reservations/availableBoats", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<PotentialBoatReservationDTO>> getAvailableBoats(@RequestBody ReservationSearchDTO search){
    	
    	System.out.println("USli u kontroler");
        try {
            return new ResponseEntity<>(boatSuggestionService.getAvailableBoats(search), HttpStatus.OK);
        } catch (Exception e){
        	System.out.println(e);
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
	@PreAuthorize("hasRole('ROLE_CLIENT')")
    @RequestMapping(method = RequestMethod.POST,value = "/reservations/availableMansions", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<PotentialMansionReservationDTO>> getAvailableMansions(@RequestBody ReservationSearchDTO search){
    	

        try {
            return new ResponseEntity<>(mansionSuggestionService.getAvailableMansions(search), HttpStatus.OK);
        } catch (Exception e){
        	System.out.println(e);
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
	@PreAuthorize("hasRole('ROLE_CLIENT')")
    @RequestMapping(method = RequestMethod.POST,value = "/reservations/createBoatReservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> createBoatReservation(@RequestBody ReservationDTO res){
    	
    	System.out.println("USli u kontroler");
        try {
        	BoatReservation newReservation = boatResService.createBoatReservation(res);
        	try {
        		mailService.sendBoatReservationConfirmationMail(boatResService.getLoggedUser(), newReservation);
        	}catch (MessagingException e){
        		return  new ResponseEntity<>("There is a problem with your mail!", HttpStatus.INTERNAL_SERVER_ERROR);
        	}
            return new ResponseEntity<>("Reservation successfull!", HttpStatus.OK);
        } catch (ParseException e){
            return  new ResponseEntity<>("Check your date again!", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PeriodNoLongerAvailableException e) {
        	return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
	@PreAuthorize("hasRole('ROLE_CLIENT')")
    @RequestMapping(method = RequestMethod.POST,value = "/reservations/createMansionReservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> createMansionReservation(@RequestBody ReservationDTO res){
    	
    	System.out.println("USli u kontroler");
        try {
        	MansionReservation newReservation = mansionResService.createMansionReservation(res);
        	try {
        		mailService.sendMansionReservationConfirmationMail(boatResService.getLoggedUser(), newReservation);
        	}catch (MessagingException e){
        		return  new ResponseEntity<>("There is a problem with your mail!", HttpStatus.INTERNAL_SERVER_ERROR);
        	}
            return new ResponseEntity<>("Reservation successfull!", HttpStatus.OK);
        } catch (ParseException e){
            return  new ResponseEntity<>("Check your date again!", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PeriodNoLongerAvailableException e) {
        	return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
	@PreAuthorize("hasRole('ROLE_CLIENT')")
    @RequestMapping(method = RequestMethod.POST,value = "/reservations/cancelBoatReservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<BoatReservation> cancelBoatReservation(@RequestBody long  resId){
    	
    	System.out.println("USli u kontroler");
        try {
            return new ResponseEntity<>(boatResService.cancelBoatReservation(resId), HttpStatus.OK);
        } catch (Exception e){
        	System.out.println(e);
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
	@PreAuthorize("hasRole('ROLE_CLIENT')")
    @RequestMapping(method = RequestMethod.POST,value = "/reservations/cancelMansionReservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<MansionReservation> cancelMansionReservation(@RequestBody long  resId){
    	
		System.out.println("res id ..");
        try {
            return new ResponseEntity<>(mansionResService.cancelMansionReservation(resId), HttpStatus.OK);
        } catch (Exception e){
        	System.out.println(e);
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ROLE_BOAT_OWNER')")
    @RequestMapping(method = RequestMethod.GET, value = "/getBoatOwnerReservations")
    public ResponseEntity<String> getBoatOwnerReservations() {
        try {
            List<BoatReservation> boatReservations = boatResService.getLoggedUserReservations();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(boatReservations);
            System.out.println(jsonString);
            return new ResponseEntity<>(jsonString, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ROLE_BOAT_OWNER')")
    @RequestMapping(method = RequestMethod.GET, value = "/getReservedDatesForBoat")
    public ResponseEntity<String> getReservedDatesForBoat(@RequestParam Long boatId){
        try {
            List<BoatReservation> boatReservations = boatResService.getBoatReservationsByBoat(boatId);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(boatReservations);
            System.out.println(jsonString);
            return new ResponseEntity<>(jsonString, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ROLE_BOAT_OWNER')")
    @RequestMapping(method = RequestMethod.POST, value = "/makeBoatReservationClient")
    public ResponseEntity<String> makeBoatReservationClient(@RequestBody MakeBoatReservationForClientDTO dto){
        System.out.println(dto);
        try{
            Boolean success = boatResService.createBoatReservationForClient(dto);
            if (success)
            return new ResponseEntity<>("Reservation for client is created successfully!", HttpStatus.OK);
            else return new ResponseEntity<>("Wrong params, try again!", HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Error when making a reservation!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
