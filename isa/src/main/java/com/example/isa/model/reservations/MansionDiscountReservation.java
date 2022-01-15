package com.example.isa.model.reservations;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.example.isa.model.ClientFeedback;
import com.example.isa.model.Mansion;

@Entity
@DiscriminatorValue("MANSION_DISCOUNT_RESERVATION")
public class MansionDiscountReservation extends DiscountReservation{



	@OneToOne
	@JoinColumn(name = "mansion_id")
	private Mansion mansion;
	
		
	@OneToOne
	@JoinColumn(name = "feedback_id")
	private ClientFeedback mansionFeedback;

	@OneToOne
	@JoinColumn(name = "owner_feedback_id")
	private ClientFeedback mansionOwnerFeedback;



	public MansionDiscountReservation(String type, Date startDate, Date endDate, int numberOfGuests,
			double priceWithDiscount, Mansion mansion, ClientFeedback mansionFeedback,
			ClientFeedback mansionOwnerFeedback) {
		super(type, startDate, endDate, numberOfGuests, priceWithDiscount);
		this.mansion = mansion;
		this.mansionFeedback = mansionFeedback;
		this.mansionOwnerFeedback = mansionOwnerFeedback;
	}
	
	

	public MansionDiscountReservation(String type, Date startDate, Date endDate, int numberOfGuests,
			double priceWithDiscount, Mansion mansion) {
		super(type, startDate, endDate, numberOfGuests, priceWithDiscount);
		this.mansion = mansion;
	}



	public MansionDiscountReservation() {
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
