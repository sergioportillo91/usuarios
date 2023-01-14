package com.gestion_usuarios.spring_boot_usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_usuarios.spring_boot_usuarios.models.Usuarios;
import com.gestion_usuarios.spring_boot_usuarios.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/getAll")
    public List<Usuarios> getAll() {
        return usuarioService.getUsuarios();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios registrar(@RequestBody Usuarios user) {
        return usuarioService.save(user);
    }

    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return usuarioService.existeEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public Usuarios autenticar(@PathVariable("email") String email, @PathVariable("password") String password) {
        return usuarioService.autenticarUsuario(email, password);
    }
}
