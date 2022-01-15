package com.example.isa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("BOAT_SUBSCRIPTION")
public class BoatSubscription extends Subscription{

	@OneToOne
	@JoinColumn(name = "boat_id")
	private Boat boat;

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public BoatSubscription(Long id, Client subscriber, Boat boat) {
		super(id, subscriber);
		this.boat = boat;
	}
	

	public BoatSubscription(User subscriber, Boat boat) {
		super(subscriber);
		this.boat = boat;
	}

	public BoatSubscription() {}

	@Override
	public String toString() {
		return "BoatSubscription{" +
				"boat=" + boat +
				'}';
	}
}
