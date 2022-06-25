package com.projetopi.expenditurecontrol.repository;

import org.springframework.data.repository.CrudRepository;

import com.projetopi.expenditurecontrol.models.Movement;

public interface MovementRepository extends CrudRepository<Movement, String>{
    
}