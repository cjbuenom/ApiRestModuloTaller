package com.example.ModuloTallersf.controller;

import com.example.ModuloTallersf.model.Certificadores;
import com.example.ModuloTallersf.service.CertificadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/certificadores")
public class CertificadoresController {

    private final CertificadoresService certificadoresService;

    @Autowired
    public CertificadoresController(CertificadoresService certificadoresService) {
        this.certificadoresService = certificadoresService;
    }

    @GetMapping
    public List<Certificadores> findAll(){
        return certificadoresService.findAll();
    }


    @PostMapping
    public Certificadores save(@RequestBody Certificadores certificadoresCurrent){
        return certificadoresService.save(certificadoresCurrent);
    }
}
