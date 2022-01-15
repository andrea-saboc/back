package com.example.isa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
@DiscriminatorValue("MANSION_SUBSCRIPTION")
public class MansionSubscription extends Subscription{

	@OneToOne
	@JoinColumn(name = "mansion_id")
	private Mansion mansion;

	public Mansion getMansion() {
		return mansion;
	}

	public void setMansion(Mansion mansion) {
		this.mansion = mansion;
	}

	public MansionSubscription(User subscriber, Mansion mansion) {
		super(subscriber);
		this.mansion = mansion;
	}
	
	public MansionSubscription(Long id,User subscriber, Mansion mansion) {
		super(id, subscriber);
		this.mansion = mansion;
	}
	
	public MansionSubscription() {}
}
