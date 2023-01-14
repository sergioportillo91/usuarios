package com.gestion_usuarios.spring_boot_usuarios.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gestion_usuarios.spring_boot_usuarios.models.Usuarios;

@Repository
public class UsuarioRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    public List<Usuarios> getAll() {
        return (List<Usuarios>) usuarioCrudRepository.findAll();
    }

    public Optional<Usuarios> getUsuarioById(int id) {
        return usuarioCrudRepository.findById(id);
    }

    public Usuarios guardar(Usuarios usuario) {
        return usuarioCrudRepository.save(usuario);
    }

    public boolean existeEmail(String email) {
        Optional<Usuarios> usuario = usuarioCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<Usuarios> autenticarUsuario(String email, String password) {
        return usuarioCrudRepository.findByEmailAndPassword(email, password);
    }
}
