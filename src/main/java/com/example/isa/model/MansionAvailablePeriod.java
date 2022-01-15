package com.example.isa.model;

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
import javax.persistence.Table;

@Entity
@Table(name = "MansionAvailablePeriod")
public class MansionAvailablePeriod {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "available_period_id")
	    private Long id;
	    @Column(name = "start_date")    
		private Date startDate;
	    @Column(name = "end_date")
		private Date endDate;

		
		@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	    @JoinColumn(name = "mansion_id", referencedColumnName = "id", nullable = true)
	    private Mansion mansion;

		

		public MansionAvailablePeriod(Date startDate, Date endDate, Mansion mansion) {
			super();
			this.startDate = startDate;
			this.endDate = endDate;
			this.mansion = mansion;
		}
		
		public MansionAvailablePeriod() {}


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


		public Mansion getMansion() {
			return mansion;
		}


		public void setMansion(Mansion mansion) {
			this.mansion = mansion;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}
		
		
		
}
