package com.example.isa.dto;

import com.example.isa.model.Client;

public class ClientRegistrationDTO {
	
    private String name;
    private String surname;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
    private String email;
    private String password;
    
    
	@Override
	public String toString() {
		return "ClientDTO [name=" + name + ", surname=" + surname + ", address=" + address + ", city=" + city
				+ ", country=" + country + ", phoneNumber=" + phoneNumber + ", email=" + email + ", password="
				+ password + "]";
	}


	public ClientRegistrationDTO(String name, String surname, String address, String city, String country, String phoneNumber,
			String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}


	public ClientRegistrationDTO() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Client createClient(ClientRegistrationDTO clientDto) {
		return new Client(clientDto.name,clientDto.surname,clientDto.address,clientDto.city,clientDto.country,clientDto.phoneNumber,clientDto.email,clientDto.password);
	}
	
}
