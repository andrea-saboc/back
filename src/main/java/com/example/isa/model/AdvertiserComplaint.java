package com.example.isa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("ADVERTISER_COMPLAINT")
public class AdvertiserComplaint extends Complaint{
	
	@OneToOne
	@JoinColumn(name = "advertiser")
	private User advertiser;

	public User getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(User advertiser) {
		this.advertiser = advertiser;
	}

	public AdvertiserComplaint(Client author, String complaintContent, User advertiser) {
		super(author, complaintContent);
		this.advertiser = advertiser;
	}

	public AdvertiserComplaint() {
		super();
	}
	
	

}
