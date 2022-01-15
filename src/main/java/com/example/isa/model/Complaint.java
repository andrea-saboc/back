package com.example.isa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Complaint {

	@Id
	@Column(name = "id", unique = true)
    @SequenceGenerator(name = "complaint_sequence_generator", sequenceName = "complaint_sequence", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaint_sequence_generator")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "system_user")
	private Client author;
	
	private String complaintContent;
	private Date date;
	private boolean approved;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComplaintContent() {
		return complaintContent;
	}
	public void setComplaintContent(String complaintContent) {
		this.complaintContent = complaintContent;
	}
	public Client getAuthor() {
		return author;
	}
	public void setAuthor(Client author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public Complaint(Client author, String complaintContent) {
		super();
		this.author = author;
		this.complaintContent = complaintContent;
		this.approved = true;
		this.date = new Date();
	}
	
	public Complaint() {
		super();
	}
	
	
	
	
	
	


	
	
	
}
