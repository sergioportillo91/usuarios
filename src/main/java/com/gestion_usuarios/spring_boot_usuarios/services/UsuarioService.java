package com.gestion_usuarios.spring_boot_usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion_usuarios.spring_boot_usuarios.models.Usuarios;
import com.gestion_usuarios.spring_boot_usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuarios> getUsuarios() {
        return usuarioRepository.getAll();
    }

    public Optional<Usuarios> getUsuarioById(int id) {
        return usuarioRepository.getUsuarioById(id);
    }

    public Usuarios save(Usuarios usuario) {

        if (usuario.getId() == null) {
            if (existeEmail(usuario.getEmail()) == false) {
                return usuarioRepository.guardar(usuario);
            } else {
                return usuario;
            }
        } else {
            return usuario;
        }
    }

    public Boolean existeEmail(String email) {
        return usuarioRepository.existeEmail(email);
    }

    public Usuarios autenticarUsuario(String email, String clave) {
        Optional<Usuarios> usuario = usuarioRepository.autenticarUsuario(email, clave);

        if (usuario.isEmpty()) {
            return new Usuarios(email, clave, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }

}
