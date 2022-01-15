package com.example.isa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProbniKontroler {
	
    @RequestMapping("/")
    public String index() {
        return "Spring Boot POC Welcomes You!";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/proba")
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> probnaMetoda(){
		System.out.println("Nalazim se u metodi :)");
		return new ResponseEntity<>("Everything is okey", HttpStatus.OK);
	}
}
