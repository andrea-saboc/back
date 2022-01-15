package com.example.isa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "subscription")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "subscription_type", discriminatorType = DiscriminatorType.STRING)
public class Subscription {

	@Id
	@Column(name = "id", unique = true)
    @SequenceGenerator(name = "subscription_sequence_generator", sequenceName = "subscription_sequence", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscription_sequence_generator")
	private Long id;		
	
	@OneToOne
	@JoinColumn(name = "subscriber_id")
	private User subscriber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(User subscriber) {
		this.subscriber = subscriber;
	}

	public Subscription(User subscriber) {
		super();
		this.subscriber = subscriber;
	}
	
	
	public Subscription(Long id, User subscriber) {
		super();
		this.id = id;
		this.subscriber = subscriber;
	}

	public Subscription() {}
	
	
	
}
