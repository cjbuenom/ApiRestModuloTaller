package com.example.ModuloTallersf.controller;



import com.example.ModuloTallersf.model.CapacidadExtintor;
import com.example.ModuloTallersf.service.CapExtintorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/capaextintor")
public class CapExtintorController {

    private final CapExtintorService capExtintorService;

    @Autowired
    public CapExtintorController(CapExtintorService capExtintorService) {
        this.capExtintorService = capExtintorService;
    }

    @GetMapping
    public List<CapacidadExtintor> findAll(){
        return capExtintorService.findAll();
    }

    @PostMapping
    public CapacidadExtintor save(@RequestBody CapacidadExtintor  capacidadExtintor){
        return capExtintorService.save(capacidadExtintor);
    }

}
