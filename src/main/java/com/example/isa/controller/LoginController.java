package com.example.isa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.dto.LoginDTO;
import com.example.isa.dto.UserTokenState;
import com.example.isa.service.LoginService;
import com.example.isa.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class LoginController {
	
	@Autowired	
	LoginService loginService;
	@Autowired
	UserService userService;

	
	@RequestMapping(method = RequestMethod.POST, value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	@CrossOrigin(origins = "*")
	public ResponseEntity<UserTokenState> login(@RequestBody LoginDTO loginData,HttpServletRequest req) throws JsonProcessingException{
		System.out.println("U kontroleru");

        UserTokenState state = loginService.logIn(loginData);
        return ResponseEntity.ok(state);		
		
	}
	

	
	@RequestMapping(method = RequestMethod.POST, value = "/checkActivationCode",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	public boolean checkActivationCode(@RequestBody String code) throws JsonProcessingException{
		
		System.out.println("controller hit" + code);
		boolean valid = loginService.checkActivationCode(code);
		if(valid) userService.activateUser(code);
        return valid;	
	}

}
