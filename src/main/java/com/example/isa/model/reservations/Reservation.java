package com.example.isa.model.reservations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.isa.model.User;

@Entity
@Table(name = "reservation")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "reservation_type", discriminatorType = DiscriminatorType.STRING)
public class Reservation {
	
	private String type="";
	
	
	@Id
	@Column(name = "id", unique = true)
    @SequenceGenerator(name = "user_sequence_generator", sequenceName = "user_sequence", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence_generator")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "system_user")
	private User user;

	private Date startDate;
	private Date endDate;
	private int numberOfGuests;
	private double totalPrice;
	private boolean cancelled;
	

	@ManyToMany
	@JoinTable(name="reservation_services",
    	joinColumns=@JoinColumn(name="reservation_id"),
       inverseJoinColumns=@JoinColumn(name="service_id "))
	public Set<AdditionalService> additionalServices = new HashSet<AdditionalService>();

	public void addService(AdditionalService service) {
		service.addReservation(this);
		additionalServices.add(service);
	}
	
		
	public Set<AdditionalService> getAdditionalServices() {
		return additionalServices;
	}


	public void setAdditionalServices(Set<AdditionalService> additionalServices) {
		this.additionalServices = additionalServices;
	}


	public Reservation(String type, User user, Date startDate, Date endDate, int numberOfGuests,double totalPrice) {
		super();
		this.cancelled = false;
		this.type = type;
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfGuests = numberOfGuests;
		this.totalPrice = totalPrice;
	}
	
	
	
	
	public Reservation() {
		super();
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}




	public Date getEndDate() {
		return endDate;
	}




	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}




	public int getNumberOfGuests() {
		return numberOfGuests;
	}




	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}




	public double getTotalPrice() {
		return totalPrice;
	}




	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public boolean isCancelled() {
		return cancelled;
	}


	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}


	
	
	
	
	
}
