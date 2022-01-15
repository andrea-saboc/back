package com.example.isa.dto;

import com.example.isa.model.BoatOwner;
import com.example.isa.model.FishingInstructor;
import com.example.isa.model.MansionOwner;

public class AdvertiserRegistrationDTO {
    private String name;
    private String surname;
    private String address;
    private String city;
    private String country;
    private String phoneNumber;
    private String email;
    private String password;
    private String type;
    private String reason;

    public AdvertiserRegistrationDTO() {
    }

    public AdvertiserRegistrationDTO(String name, String surname, String address, String city, String country, String phoneNumber, String email, String password, String type, String reason) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.type = type;
        this.reason = reason;
    }



    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "AdvertiserRegistrationDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BoatOwner  createBoatOwner() {
        BoatOwner boatOwner = new BoatOwner(
                name,
                surname,
                address,
                city,
                country,
                phoneNumber,
                email,
                password,
                reason,
                "boat",
                false
                );
        return boatOwner;
    }

    public MansionOwner createMansionOwner() {
        MansionOwner mansionOwner = new MansionOwner(
                name,
                surname,
                address,
                city,
                country,
                phoneNumber,
                email,
                password,
                reason,
                "mansion",
                false
        );
        return mansionOwner;
    }
    public FishingInstructor createFishingInstructor() {
    	FishingInstructor fishingInstructor = new FishingInstructor(
                name,
                surname,
                address,
                city,
                country,
                phoneNumber,
                email,
                password,
                reason,
                "fishing",
                false
        );
        return fishingInstructor;
    }
}
