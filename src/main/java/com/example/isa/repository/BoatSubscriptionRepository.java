package com.example.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Boat;
import com.example.isa.model.BoatSubscription;
import com.example.isa.model.User;

public interface BoatSubscriptionRepository extends JpaRepository<BoatSubscription,Long>{
	
	List<BoatSubscription> findAllBySubscriber(User user);
	BoatSubscription findById(long id);
	BoatSubscription findBySubscriberAndBoat(User user,Boat boat);

}
