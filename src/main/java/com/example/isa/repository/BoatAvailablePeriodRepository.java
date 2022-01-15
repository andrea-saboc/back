package com.example.isa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.isa.model.BoatAvailablePeriod;
import com.example.isa.model.Boat;

public interface BoatAvailablePeriodRepository extends JpaRepository<BoatAvailablePeriod, Long> {
    List<BoatAvailablePeriod> findByBoat(Boat boat);
 

    @Query(value = "SELECT available_period_id,start_date,end_date,boat_id FROM public.boat_available_period u WHERE u.start_date <= :startDate AND u.end_date >= :endDate AND u.boat_id = :id",
    		nativeQuery = true)
    BoatAvailablePeriod getPeriodOfInterest(@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("id") long id);
    
    
    @Query(value = "SELECT available_period_id,start_date,end_date,boat_id FROM public.boat_available_period u WHERE u.end_date = :endDate",
    		nativeQuery = true)   
    BoatAvailablePeriod checkIfPeriodHasEndDate(@Param("endDate") Date endDate);   
    
    @Query(value = "SELECT available_period_id,start_date,end_date,boat_id FROM public.boat_available_period u WHERE u.start_date = :startDate",
    		nativeQuery = true)   
    BoatAvailablePeriod checkIfPeriodHasStartDate(@Param("startDate") Date startDate); 
}
