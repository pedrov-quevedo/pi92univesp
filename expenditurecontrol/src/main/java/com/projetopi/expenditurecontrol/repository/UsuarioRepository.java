package com.projetopi.expenditurecontrol.repository;

import org.springframework.data.repository.CrudRepository;

import com.projetopi.expenditurecontrol.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Usuario findByLogin(String login);
}
