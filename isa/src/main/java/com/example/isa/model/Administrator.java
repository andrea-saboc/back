package com.example.isa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Administrator")
public class Administrator extends User{

	private Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Administrator(String name, String surname, String address, String city, String country, String phoneNumber,
			String email, String password) {
		super(name, surname, address, city, country, phoneNumber, email, password);
		// TODO Auto-generated constructor stub
	}

	private Administrator(String email, String password) {
		super(email, password);
		// TODO Auto-generated constructor stub
	}
	
	

}
