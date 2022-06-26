package com.projetopi.expenditurecontrol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.projetopi.expenditurecontrol.models.Movement;

public interface MovementRepository extends CrudRepository<Movement, String>{
    Iterable<Movement> findAllByUsuario(@Param("usuario") String usuario);
}