package com.gestion_usuarios.spring_boot_usuarios.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gestion_usuarios.spring_boot_usuarios.models.Usuarios;

public interface UsuarioCrudRepository extends CrudRepository<Usuarios, Integer> {
    Optional<Usuarios> findByEmail(String email);

    Optional<Usuarios> findByEmailAndPassword(String email, String password);
}
