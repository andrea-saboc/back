package com.example.isa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("MANSION_COMPLAINT")
public class MansionComplaint extends Complaint{
	
	@OneToOne
	@JoinColumn(name = "mansion")
	private Mansion mansion;

	public Mansion getMansion() {
		return mansion;
	}

	public void setMansion(Mansion mansion) {
		this.mansion = mansion;
	}

	public MansionComplaint(Client author, String complaintContent, Mansion mansion) {
		super(author, complaintContent);
		this.mansion = mansion;
	}
	
	public MansionComplaint() {
		super();
	}

}
