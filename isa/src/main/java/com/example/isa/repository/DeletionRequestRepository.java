package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.AccountDeletionRequest;

public interface DeletionRequestRepository extends JpaRepository<AccountDeletionRequest, Long> {

}
