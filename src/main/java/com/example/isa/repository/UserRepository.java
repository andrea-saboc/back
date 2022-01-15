package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.isa.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
