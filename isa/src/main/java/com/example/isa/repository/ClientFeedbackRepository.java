package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.ClientFeedback;

public interface ClientFeedbackRepository extends JpaRepository<ClientFeedback,Long>{

}
