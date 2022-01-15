package com.example.isa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("BoatOwner")
public class BoatOwner extends User{
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
   //private Integer IDAdvertiser;
    @Column(name = "advertiser_reason")
    private String reason;
    @Column(name = "type")
    private String advertiserType;
    @Column(name = "advertiser_registration_approved")
    private boolean approved;



    public BoatOwner(){}

    public BoatOwner(String reason, boolean approved) {
        this.reason = reason;
        this.approved = approved;
    }

    public BoatOwner(String email, String password, String reason, boolean approved) {
        super(email, password);
        this.reason = reason;
        this.approved = approved;
    }

    public BoatOwner(String name, String surname, String address, String city, String country, String phoneNumber, String email, String password, String reason, String type, boolean approved) {
        super(name, surname, address, city, country, phoneNumber, email, password);
        this.advertiserType = type;
        this.reason = reason;
        this.approved = approved;
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

  /*  public Set<Boat> getBoats() {
        return boats;
    }

    public void setBoats(Set<Boat> boats) {
        this.boats = boats;
    }
    public void addBoat(Boat newBoat){
        this.boats.add(newBoat);
    }*/
}
