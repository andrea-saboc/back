package com.example.isa.dto;

import javax.persistence.Column;

public class AdvertisersDTO {
	
	public Long id;
	public String name;
	public String surname;
	public String address;
	public String city;
	public String country;
	public String phoneNumber;
	public String email;
	public String password;
	public String reason;
	public String advertiserType;
	public boolean approved;
	private AdvertisersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getAdvertiserType() {
		return advertiserType;
	}
	public void setAdvertiserType(String advertiserType) {
		this.advertiserType = advertiserType;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public AdvertisersDTO(Long id, String name, String surname, String address, String city, String country,
			String phoneNumber, String email, String password, String reason, String advertiserType, boolean approved) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.reason = reason;
		this.advertiserType = advertiserType;
		this.approved = approved;
	}
	public AdvertisersDTO(String email, String reason) {
		super();
		this.email = email;
		this.reason = reason;
		
	}
	
	
    

}
