package com.example.isa.dto;

import java.util.List;

public class ActiveReservationDTO {
	
	private long reservationId;
	private String reservationType;
	
	private String startDate;
	private String endDate;
	private int numberOfGuests;	
	private List<String> additinalServices;
	private double totalPrice;
	
	private String entityName;
	private String entityAddress;
	private String entityPromo;

	private boolean allowedCancelation;

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public List<String> getAdditinalServices() {
		return additinalServices;
	}

	public void setAdditinalServices(List<String> additinalServices) {
		this.additinalServices = additinalServices;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityAddress() {
		return entityAddress;
	}

	public void setEntityAddress(String entityAddress) {
		this.entityAddress = entityAddress;
	}

	public String getEntityPromo() {
		return entityPromo;
	}

	public void setEntityPromo(String entityPromo) {
		this.entityPromo = entityPromo;
	}

	public boolean isAllowedCancelation() {
		return allowedCancelation;
	}

	public void setAllowedCancelation(boolean allowedCancelation) {
		this.allowedCancelation = allowedCancelation;
	}

	public ActiveReservationDTO(long reservationId, String reservationType, String startDate, String endDate,
			int numberOfGuests, List<String> additinalServices, double totalPrice, String entityName,
			String entityAddress, String entityPromo, boolean allowedCancelation) {
		super();
		this.reservationId = reservationId;
		this.reservationType = reservationType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfGuests = numberOfGuests;
		this.additinalServices = additinalServices;
		this.totalPrice = totalPrice;
		this.entityName = entityName;
		this.entityAddress = entityAddress;
		this.entityPromo = entityPromo;
		this.allowedCancelation = allowedCancelation;
	}

	public ActiveReservationDTO() {
		super();
	}
	
	
	
}
