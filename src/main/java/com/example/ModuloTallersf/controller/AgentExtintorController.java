package com.example.ModuloTallersf.controller;

import com.example.ModuloTallersf.model.AgenteExtintor;
import com.example.ModuloTallersf.service.AgenteExtintorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/agentextintor")
public class AgentExtintorController {

    private final AgenteExtintorService agenteExtintorService;

    @Autowired
    public AgentExtintorController(AgenteExtintorService agenteExtintorService) {
        this.agenteExtintorService = agenteExtintorService;
    }

    @GetMapping
    public List<AgenteExtintor> findAll(){
        return agenteExtintorService.findAll();
    }

    @PostMapping
    public AgenteExtintor save(@RequestBody AgenteExtintor agenteExtintorCurrent){
        return agenteExtintorService.save(agenteExtintorCurrent);
    }
}
