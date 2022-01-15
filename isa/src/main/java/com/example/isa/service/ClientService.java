package com.example.isa.service;

import org.springframework.stereotype.Service;

import com.example.isa.dto.LoginDTO;
import com.example.isa.enums.UserType;
import com.example.isa.model.User;

@Service
public class ClientService {
	
	
	public boolean userExists(String email) {
		return true;
	}
	
	public boolean passwordInvalid(LoginDTO loginData) {	
		return true;
	}
	
	public User loginUser(LoginDTO loginData) {

		return null;
	}
	

}
