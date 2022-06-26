package com.example.ModuloTallersf.controller;


import com.example.ModuloTallersf.model.OrdenesServicio;
import com.example.ModuloTallersf.service.OrdeneServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/ordeneservicio")
public class OrdeneServicioController {

    private final OrdeneServicioService ordeneServicioService;

    @Autowired
    public OrdeneServicioController(OrdeneServicioService ordeneServicioService) {
        this.ordeneServicioService = ordeneServicioService;
    }

    @GetMapping
    public List<OrdenesServicio> findAll(){
        return ordeneServicioService.findAll();
    }

    @PostMapping
    public OrdenesServicio save(@RequestBody OrdenesServicio ordenesServicioCurrent){
        return ordeneServicioService.save(ordenesServicioCurrent);
    }
}
