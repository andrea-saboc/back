package com.example.isa.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="Adventure")
public class Adventure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "advanture_name", nullable = false)
	private String name;
	@Column(name = "advanture_adress", nullable = false)
	private String address;
	@Column(name = "promo_description", nullable = false)
	private String promoDescriptions;
	@Column(name = "advanture_grade", nullable = false)
	private float avgGrade;
		

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPromoDescriptions() {
		return promoDescriptions;
	}
	public void setPromoDescriptions(String promoDescriptions) {
		this.promoDescriptions = promoDescriptions;
	}
	public float getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(float avgGrade) {
		this.avgGrade = avgGrade;
	}
	
	public Adventure(String name, String address, String promoDescriptions, float avgGrade) {
		super();
		this.name = name;
		this.address = address;
		this.promoDescriptions = promoDescriptions;
		this.avgGrade = avgGrade;
	}

	public Adventure() {
		super();
	}
}
