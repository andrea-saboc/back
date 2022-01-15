package com.example.isa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.isa.model.BoatAvailablePeriod;
import com.example.isa.model.Mansion;
import com.example.isa.model.MansionAvailablePeriod;

public interface MansionAvailablePeriodRepository extends JpaRepository<MansionAvailablePeriod,Long>{

    List<MansionAvailablePeriod> findByMansion(Mansion mansion);
    

    @Query(value = "SELECT available_period_id,start_date,end_date,mansion_id FROM public.mansion_available_period u WHERE u.start_date <= :startDate AND u.end_date >= :endDate AND u.mansion_id = :id",
    		nativeQuery = true)
    MansionAvailablePeriod getPeriodOfInterest(@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("id") long id);
      
    @Query(value = "SELECT available_period_id,start_date,end_date,mansion_id FROM public.mansion_available_period u WHERE u.end_date = :endDate",
    		nativeQuery = true)   
    MansionAvailablePeriod checkIfPeriodHasEndDate(@Param("endDate") Date endDate);   
    
    @Query(value = "SELECT available_period_id,start_date,end_date,mansion_id FROM public.mansion_available_period u WHERE u.start_date = :startDate",
    		nativeQuery = true)   
    MansionAvailablePeriod checkIfPeriodHasStartDate(@Param("startDate") Date startDate); 
}
