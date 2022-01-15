package com.example.isa.model.reservations;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.isa.model.ClientFeedback;
import com.example.isa.model.Mansion;
import com.example.isa.model.User;


@Entity
@DiscriminatorValue("MANSION_RESERVATION")
public class MansionReservation extends Reservation{
	
	@OneToOne
	@JoinColumn(name = "mansion_id")
	private Mansion mansion;
	
	@OneToOne
	@JoinColumn(name = "feedback_id")
	private ClientFeedback mansionFeedback;

	@OneToOne
	@JoinColumn(name = "owner_feedback_id")
	private ClientFeedback mansionOwnerFeedback;




	public MansionReservation(User user, Date startDate, Date endDate, int numberOfGuests,
			double totalPrice, Mansion mansion) {
		super("MANSION", user, startDate, endDate, numberOfGuests, totalPrice);
		this.mansion = mansion;
	}
	
	public MansionReservation() {
		super();
	}

	public Mansion getMansion() {
		return mansion;
	}

	public void setBoat(Mansion mansion) {
		this.mansion = mansion;
	}

	public ClientFeedback getMansionFeedback() {
		return mansionFeedback;
	}

	public void setMansionFeedback(ClientFeedback mansionFeedback) {
		this.mansionFeedback = mansionFeedback;
	}

	public ClientFeedback getMansionOwnerFeedback() {
		return mansionOwnerFeedback;
	}

	public void setMansionOwnerFeedback(ClientFeedback mansionOwnerFeedback) {
		this.mansionOwnerFeedback = mansionOwnerFeedback;
	}

	public void setMansion(Mansion mansion) {
		this.mansion = mansion;
	}
	
	


}
