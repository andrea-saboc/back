package com.example.isa.dto;

import java.util.List;

public class PotentialBoatReservationDTO {
	
	private long boatId;
	private String name;
	private String promoDescription;
	private float avgGrade;
	
	private int capacity;
	private String cancellationPolicy;
	private double pricePerHour;
	private double pricePerDay;
	
	
	private double totalPrice;
	private List<String> additionalServices;
	private List<Long> additinalServicesId;
	
	public long getBoatId() {
		return boatId;
	}
	public void setBoatId(long boatId) {
		this.boatId = boatId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPromoDescription() {
		return promoDescription;
	}
	public void setPromoDescription(String promoDescription) {
		this.promoDescription = promoDescription;
	}
	public float getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(float avgGrade) {
		this.avgGrade = avgGrade;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<String> getAdditionalServices() {
		return additionalServices;
	}
	public void setAdditionalServices(List<String> additinalServices) {
		this.additionalServices = additinalServices;
	}
	
	public PotentialBoatReservationDTO() {
		super();
	}
	public String getCancellationPolicy() {
		return cancellationPolicy;
	}
	public void setCancellationPolicy(String cancellationPolicy) {
		this.cancellationPolicy = cancellationPolicy;
	}
	public double getPricePerHour() {
		return pricePerHour;
	}
	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public List<Long> getAdditinalServicesId() {
		return additinalServicesId;
	}
	public void setAdditinalServicesId(List<Long> additinalServicesId) {
		this.additinalServicesId = additinalServicesId;
	}
	
	
	public PotentialBoatReservationDTO(long boatId, String name, String promoDescription, float avgGrade, int capacity,
			String cancellationPolicy, double pricePerHour, double pricePerDay, double totalPrice,
			List<String> additionalServices, List<Long> additinalServicesId) {
		super();
		this.boatId = boatId;
		this.name = name;
		this.promoDescription = promoDescription;
		this.avgGrade = avgGrade;
		this.capacity = capacity;
		this.cancellationPolicy = cancellationPolicy;
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.totalPrice = totalPrice;
		this.additionalServices = additionalServices;
		this.additinalServicesId = additinalServicesId;
	}

	

	
	
	
	

}
