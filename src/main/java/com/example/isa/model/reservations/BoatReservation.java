package com.example.isa.model.reservations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.example.isa.model.Boat;
import com.example.isa.model.ClientFeedback;
import com.example.isa.model.User;

@Entity
@DiscriminatorValue("BOAT_RESERVATION")
public class BoatReservation extends Reservation{
	
	@OneToOne
	@JoinColumn(name = "boat_id")
	private Boat boat;
	
	@OneToOne
	@JoinColumn(name = "feedback_id")
	private ClientFeedback boatFeedback;

	@OneToOne
	@JoinColumn(name = "owner_feedback_id")
	private ClientFeedback boatOwnerFeedback;



	
	public BoatReservation(User user, Date startDate, Date endDate, int numberOfGuests, double totalPrice,
			Boat boat) {
		super("BOAT", user, startDate, endDate, numberOfGuests, totalPrice);
		this.boat = boat;
	}

	public BoatReservation() {
		super();
	}

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public ClientFeedback getBoatFeedback() {
		return boatFeedback;
	}

	public void setBoatFeedback(ClientFeedback boatFeedback) {
		this.boatFeedback = boatFeedback;
	}

	public ClientFeedback getBoatOwnerFeedback() {
		return boatOwnerFeedback;
	}

	public void setBoatOwnerFeedback(ClientFeedback boatOwnerFeedback) {
		this.boatOwnerFeedback = boatOwnerFeedback;
	}




}
