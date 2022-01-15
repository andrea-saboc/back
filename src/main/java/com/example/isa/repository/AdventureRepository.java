package com.example.isa.repository;

import com.example.isa.model.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface AdventureRepository extends CrudRepository<Adventure, Integer> {
}
