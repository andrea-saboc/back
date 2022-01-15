package com.example.isa.controller;

import java.util.Collection;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.dto.AddAvailablePeriodDTO;
import com.example.isa.dto.BoatRegistrationDTO;
import com.example.isa.dto.LongIdDTO;
import com.example.isa.dto.SearchDTO;
import com.example.isa.model.Boat;
import com.example.isa.model.BoatAvailablePeriod;
import com.example.isa.model.User;
import com.example.isa.service.BoatFilteringService;
import com.example.isa.service.BoatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BoatController {
	
	@Autowired
	private BoatService service;
	@Autowired
	private BoatFilteringService filteringService;

	public BoatController(BoatService bs){
		this.service = bs;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/boat",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getBoatById(@RequestParam Long id) throws JsonProcessingException{
		System.out.println("We are searchinng for" +id);
		Boat boat = service.getById(id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(boat);
		System.out.println(jsonString);
		return new ResponseEntity<>(jsonString, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/boats",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> getAllBoats() throws JsonProcessingException{
		System.out.println("Unutar boats ");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("USER IZ KON "+user.getEmail());
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		for(GrantedAuthority v:authorities ){
			System.out.println(v.getAuthority());
		}
		System.out.println("Roles " + user.getAuthorities().getClass().toGenericString());
		List <Boat> boats = service.getAll();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(boats);
		System.out.println(jsonString);
		System.out.println("In contoler");
				
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/ownersBoats",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> getOwnersBoats() throws JsonProcessingException{
		List<Boat> boats = service.getByOwnerId();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(boats);
		System.out.println(jsonString);
		System.out.println("In contoler");
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registerBoat",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> registerBoat(@RequestBody BoatRegistrationDTO dto){
		System.out.println("In registering boat service");
		System.out.println(dto);
		Boat savedBoat = service.registerBoat(dto);

		String responseMessege;
		if (savedBoat != null){
			responseMessege = "Boat successfully registered!";
		} else{
			responseMessege = "Error ocured while saving boat!";
		}
		return new ResponseEntity<>(responseMessege, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getBoatAvailability", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<BoatAvailablePeriod>> getAvailablePeriod(@RequestBody LongIdDTO dto) throws JsonProcessingException{
		System.out.println("In getting availability for boats");
		List<BoatAvailablePeriod> boatAvailabilities = service.getBoatAvailbilities(dto.boatId);
		ObjectMapper mapper = new ObjectMapper();
		System.out.print("Before coverting" + boatAvailabilities.toString());
		String jsonString = mapper.writeValueAsString(boatAvailabilities);
		System.out.println(jsonString);
		System.out.println("In contoler");
		return new ResponseEntity<>(boatAvailabilities, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value ="/addAvailablePeriodForBoat", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> addAvailablePeriodForBoat(@RequestBody AddAvailablePeriodDTO dto) throws JsonProcessingException{
		System.out.println("Adding available period for boat!");
		List<BoatAvailablePeriod> boatAvailabilities = service.addBoatAvailabilities(dto);
		ObjectMapper mapper = new ObjectMapper();
		System.out.print("Before coverting" + boatAvailabilities.toString());
		String jsonString = mapper.writeValueAsString(boatAvailabilities);
		System.out.println(jsonString);
		System.out.println("Finished");
		return new ResponseEntity<>(jsonString, HttpStatus.OK);
	}
	
    @RequestMapping(method = RequestMethod.POST,value = "/boats/search",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Boat>> getAvailableBoats(@RequestBody SearchDTO search){
    	
    	System.out.println("USli u kontroler");
        try {
            return new ResponseEntity<>(filteringService.searchAll(search), HttpStatus.OK);
        } catch (Exception e){
        	System.out.println(e);
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, value = "/freeDaysForBoat",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<AddAvailablePeriodDTO>> getFreeDaysForBoat(@RequestBody LongIdDTO boatID){
		System.out.println("I'm trying to get boat id:"+ boatID.boatId);
		try{
			List<AddAvailablePeriodDTO> av = service.getFreeDaysForBoat(boatID.boatId);
			return new ResponseEntity<>(av , HttpStatus.OK);
		} catch (Exception e){
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
