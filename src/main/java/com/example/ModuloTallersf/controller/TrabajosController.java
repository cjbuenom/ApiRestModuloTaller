package com.example.ModuloTallersf.controller;

import com.example.ModuloTallersf.model.Trabajos;
import com.example.ModuloTallersf.service.TrabajosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/trabajos")
public class TrabajosController {

    private final TrabajosService trabajosService;

    @Autowired
    public TrabajosController(TrabajosService trabajosService) {
        this.trabajosService = trabajosService;
    }

    @GetMapping
    public List<Trabajos> findAll(){
        return trabajosService.findAll();
    }

    @PostMapping
    public Trabajos save(@RequestBody Trabajos trabajoCurrent){
        return trabajosService.save(trabajoCurrent);
    }
}
