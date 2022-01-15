package com.example.isa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BoatAvailablePeriod")
public class BoatAvailablePeriod{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",  sequenceName = "bperiod_id_seq")
    @Column(name = "available_period_id")
    public Long id;
    
    @Column(name = "start_date")    
	private Date startDate;
    @Column(name = "end_date")
	private Date endDate;

	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "boat_id", referencedColumnName = "id", nullable = true)
    private Boat boat;

	public BoatAvailablePeriod(Long id, Date startDate, Date endDate, Boat boat) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.boat = boat;
	}

	public BoatAvailablePeriod(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}


	
	public BoatAvailablePeriod() {}

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

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public BoatAvailablePeriod(Date startDate, Date endDate, Boat boat) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.boat = boat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AvailablePeriod{" +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", boat=" + boat +
				'}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boat == null) ? 0 : boat.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoatAvailablePeriod other = (BoatAvailablePeriod) obj;
		if (boat == null) {
			if (other.boat != null)
				return false;
		} else if (!boat.equals(other.boat))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	
}
