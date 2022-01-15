package com.example.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.dto.SearchDTO;
import com.example.isa.model.Mansion;
import com.example.isa.service.MansionFilteringService;
import com.example.isa.service.MansionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MansionController {
	
	@Autowired
	MansionService service;
	@Autowired
	MansionFilteringService filteringService;

	@RequestMapping(method = RequestMethod.GET, value = "/mansions",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> registerClient() throws JsonProcessingException{
		
		List <Mansion> mansions = service.getAll();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(mansions);
		System.out.println(jsonString);
		System.out.println("In contoler");
				
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}
	
    @RequestMapping(method = RequestMethod.POST,value = "/mansions/search",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Mansion>> getAvailableBoats(@RequestBody SearchDTO search){
    	
    	System.out.println("USli u kontroler");
        try {
            return new ResponseEntity<>(filteringService.searchAll(search), HttpStatus.OK);
        } catch (Exception e){
        	System.out.println(e);
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	

}
