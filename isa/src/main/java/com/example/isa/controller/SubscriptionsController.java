package com.example.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.isa.model.Boat;
import com.example.isa.model.BoatSubscription;
import com.example.isa.model.Mansion;
import com.example.isa.model.MansionSubscription;
import com.example.isa.service.SubscriptionService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class SubscriptionsController {
	
	@Autowired
	SubscriptionService service;
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/subscriptions/newBoatSubscription",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BoatSubscription> newBoatSubscriptions(@RequestBody Boat boat) throws JsonProcessingException{
		
		System.out.println("Id broda je "+boat.getName());
    	try {
            return new ResponseEntity<>(service.newBoatSubscription(boat), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/subscriptions/newMansionSubscription",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MansionSubscription> newMansionSubscriptions(@RequestBody Mansion mansion) throws JsonProcessingException{
		
    	try {
            return new ResponseEntity<>(service.newMansionSubscription(mansion), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.GET, value = "/subscriptions/boats",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BoatSubscription>> getClientBoatSubscriptions() throws JsonProcessingException{

    	try {
            return new ResponseEntity<>(service.getClientBoatSubscription(), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

	@PreAuthorize("hasRole('ROLE_BOAT_OWNER')")
	@RequestMapping(method = RequestMethod.GET, value = "/subscriptions/boatsByBoatOwner", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BoatSubscription>> getClientBoatSubscriptionByBoatOwner(@RequestParam Long id) throws JsonProcessingException{
			System.out.println("U kontroleru trazimo pretplatnike na brodove");
			return new ResponseEntity<>(service.getClientBoatSubscriptionByBoatOwner(id), HttpStatus.OK);

	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.GET, value = "/subscriptions/mansions",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MansionSubscription>> getClientMansionSubscriptions() throws JsonProcessingException{

    	try {
            return new ResponseEntity<>(service.getClientMansionSubscription(), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/subscriptions/cancelMansionSub",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> cancelMansionSubscriptions(@RequestBody MansionSubscription mansion) throws JsonProcessingException{
		
    	try {
    		service.cancelMansionSubscription(mansion);
            return new ResponseEntity<>("You are no longer subscribed to this mansion",HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PreAuthorize("hasRole('ROLE_CLIENT')")
	@RequestMapping(method = RequestMethod.POST, value = "/subscriptions/cancelBoatSub",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> cancelBoatSubscriptions(@RequestBody BoatSubscription boat) throws JsonProcessingException{
		

    	try {
    		service.cancelBoatSubscription(boat);
            return new ResponseEntity<>("You are no longer subscribed to this boat",HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_CLIENT','ROLE_BOAT_OWNER,'ROLE_MANSION_OWNER'')")
	@RequestMapping(method = RequestMethod.POST, value = "/subscriptions/checkBoatSubscription",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> checkBoatSubscriptions(@RequestBody Boat boat) throws JsonProcessingException{
		System.out.println("usli u koneojer");

    	try {
            return new ResponseEntity<>(service.checkBoatSubscription(boat),HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
}
