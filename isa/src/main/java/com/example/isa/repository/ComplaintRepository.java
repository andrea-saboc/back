package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint,Long>{


}
