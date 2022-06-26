package com.example.ModuloTallersf.controller;

import com.example.ModuloTallersf.model.DetalleOrdenServicio;
import com.example.ModuloTallersf.service.DetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/detalleorderservice")
public class DetalleOrdenController {

    private final DetalleOrdenService detalleOrdenService;

    @Autowired
    public DetalleOrdenController(DetalleOrdenService detalleOrdenService) {
        this.detalleOrdenService = detalleOrdenService;
    }

    @GetMapping
    public List<DetalleOrdenServicio> findAll(){
        return detalleOrdenService.findAll();
    }

    @PostMapping
    public DetalleOrdenServicio save (@RequestBody DetalleOrdenServicio detalleOrderserCurrent){
        return detalleOrdenService.save(detalleOrderserCurrent);
    }
}
