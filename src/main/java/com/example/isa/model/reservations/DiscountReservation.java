package com.example.isa.model.reservations;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.example.isa.model.User;

@Entity
@Table(name = "discount_reservation")
@Inheritance(strategy = InheritanceType.JOINED)
public class DiscountReservation implements Serializable{

	private static final long serialVersionUID = 6715093951843998707L;
	
    @Version
    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private long version = 0L;
    
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
	private double priceWithDiscount;
	private boolean reserved;
	private boolean cancelled;


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public double getPriceWithDiscount() {
		return priceWithDiscount;
	}
	public void setPriceWithDiscount(double priceWithDiscount) {
		this.priceWithDiscount = priceWithDiscount;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public boolean isCancelled() {
		return cancelled;
	}
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	
	public DiscountReservation() {}

	public DiscountReservation(String type, Date startDate, Date endDate, int numberOfGuests,
			double priceWithDiscount) {
		super();
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfGuests = numberOfGuests;
		this.priceWithDiscount = priceWithDiscount;
		this.cancelled = false;
		this.reserved = false;
	}
	
	
	
	

	
}
