package com.example.isa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("BOAT_COMPLAINT")
public class BoatComplaint extends Complaint{
	
	@OneToOne
	@JoinColumn(name = "boat")
	private Boat boat;

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public BoatComplaint(Client author, String complaintContent, Boat boat) {
		super(author, complaintContent);
		this.boat = boat;
	}

	public BoatComplaint() {
		super();
	}
	
	

}
