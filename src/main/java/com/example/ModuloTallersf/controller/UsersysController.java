package com.example.ModuloTallersf.controller;

import com.example.ModuloTallersf.model.Trabajos;
import com.example.ModuloTallersf.model.UserSys;
import com.example.ModuloTallersf.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/usuario")
public class UsersysController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsersysController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UserSys> findAll(){
        return usuarioService.findAll();
    }

    @PostMapping
    public UserSys save(@RequestBody UserSys userSys){
        return usuarioService.save(userSys);
    }
}
