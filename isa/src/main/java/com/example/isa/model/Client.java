package com.example.isa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@DiscriminatorValue("CLIENT")
public class Client extends User{
	
	private transient final String role = "ROLE_CLIENT";
	
	private static final long serialVersionUID = 1L;
	
    //@Column(name = "client_activation_code", length = 64)
    private String activationCode;

    @Column(name = "client_penalty_points")
    private int penaltyPoints;

    @Column(name = "client_loyalty_points")
    private int loyaltyPoints;
    
    public Client() {
        super();
    }

    public Client(String name, String surname, String address, String city, String country, String phoneNumber,
			String email, String password, int penaltyPoints,int loyaltyPoints) {
    	
        super(name,surname,address,city,country,phoneNumber,email, password);
        this.penaltyPoints = penaltyPoints;
        this.loyaltyPoints = loyaltyPoints;
        
    }
    
    public Client(String name, String surname, String address, String city, String country, String phoneNumber,
			String email, String password) {
    	
        super(name,surname,address,city,country,phoneNumber,email, password);
        
    }

    @Override
    public String getRole() {
        return role;
    }

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public int getPenaltyPoints() {
		return penaltyPoints;
	}

	public void setPenaltyPoints(int penaltyPoints) {
		this.penaltyPoints = penaltyPoints;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((activationCode == null) ? 0 : activationCode.hashCode());
		result = prime * result + loyaltyPoints;
		result = prime * result + penaltyPoints;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (activationCode == null) {
			if (other.activationCode != null)
				return false;
		} else if (!activationCode.equals(other.activationCode))
			return false;
		if (loyaltyPoints != other.loyaltyPoints)
			return false;
		if (penaltyPoints != other.penaltyPoints)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client{" +
				"role='" + role + '\'' +
				", activationCode='" + activationCode + '\'' +
				", penaltyPoints=" + penaltyPoints +
				", loyaltyPoints=" + loyaltyPoints +
				", id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", address='" + address + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				'}';
	}
}
