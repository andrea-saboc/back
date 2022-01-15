package com.example.isa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.dto.AdvertisersDTO;
import com.example.isa.service.AdvertisersService;



@RestController
public class AdvertisersController {
	
	private final AdvertisersService advertisersService;
	    

	    @Autowired
	    public AdvertisersController(AdvertisersService advertisersService) {
	        this.advertisersService = advertisersService;
	    }
	    
	     @RequestMapping(value = "/getAllAdvertisers", produces = MediaType.APPLICATION_JSON_VALUE)
	 	 @CrossOrigin(origins = "*")
	    public ResponseEntity<List<AdvertisersDTO>> getAllUser() {
	        try {
	            return new ResponseEntity<>(advertisersService.getAllAdvertisers(), HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	
	

}
