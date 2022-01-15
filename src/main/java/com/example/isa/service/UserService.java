package com.example.isa.service;


import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.isa.model.AccountDeletionRequest;
import com.example.isa.model.Client;
import com.example.isa.model.User;
import com.example.isa.repository.ClientRepository;
import com.example.isa.repository.DeletionRequestRepository;
import com.example.isa.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
    private DeletionRequestRepository deletionRequestRepository;
    @Autowired
    private AuthenticationManager authentication;
	
	public Iterable<User> findAll()  throws AccessDeniedException{
		return userRepository.findAll();
	}
	/*
	public User save(ClientRegistrationDTO userRequest) {
		User u = new User();
		u.setEmail(userRequest.getEmail());
		
		// pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
		// treba voditi racuna da se koristi isi password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		
		u.setName(userRequest.getName());
		u.setSurname(userRequest.getSurname());
		
		u.setEmail(userRequest.getEmail());

		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		//List<Role> roles = roleService.findByName("ROLE_USER");
		//u.setRoles(roles);
		
		return this.userRepository.save(u);
	}
	*/
	public User getLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}
	
    public User updateUserInfo(User user) {
    	
    	//moze samo swith za user type i svi koriste funkciju 
    	//moze da se ovo setovanje stavi u odvojenu funkciju
        Client c = clientRepository.findByEmail(user.getEmail());
        c.setName(user.getName());
        c.setSurname(user.getSurname());

        clientRepository.save(c);
        return user;
   
    }
    
    public void activateUser(String code) {
    	Client client = clientRepository.findByBlockedAndActivationCode(true, code);
    	client.setBlocked(false);
    	clientRepository.save(client);
    }
	public User createDeletionRequest(String reason) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getName());
		deletionRequestRepository.save(new AccountDeletionRequest(user.getId(),reason));
		
		return user;
	}

    public boolean checkIfClientEmailExists(String email) {
		boolean exsists = false;
		try {
			Client client = clientRepository.findByEmail(email);
			if (client != null) {
				exsists = true;
			}
		} catch (Exception e){
			exsists = false;
		}
		return exsists;
    }
}
