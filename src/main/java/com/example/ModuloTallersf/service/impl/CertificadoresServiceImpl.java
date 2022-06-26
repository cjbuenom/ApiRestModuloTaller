package com.example.ModuloTallersf.service.impl;


import com.example.ModuloTallersf.exception.ModelNotFoundException;
import com.example.ModuloTallersf.model.Certificadores;
import com.example.ModuloTallersf.model.Cliente;
import com.example.ModuloTallersf.repository.CertificadoresRepository;
import com.example.ModuloTallersf.service.CertificadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificadoresServiceImpl implements CertificadoresService {

    private final CertificadoresRepository certificadoresRepository;

    @Autowired
    public CertificadoresServiceImpl(CertificadoresRepository certificadoresRepository) {
        this.certificadoresRepository = certificadoresRepository;
    }


    @Override
    public List<Certificadores> findAll() {
        return certificadoresRepository.findAll();
    }

    @Override
    public Certificadores save(Certificadores certificadoresCurrent) {
        return certificadoresRepository.save(certificadoresCurrent);
    }

    @Override
    public Certificadores modificar(Certificadores obj) {
        return certificadoresRepository.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        certificadoresRepository.deleteById(id);
        return true;
    }

    @Override
    public Certificadores leerPorId(Integer id) throws ModelNotFoundException {
        Optional<Certificadores> certificador = certificadoresRepository.findById(id);
        if(certificador.isPresent()){
            return certificador.get();
        }else{
            throw new ModelNotFoundException("Error al encontrar al certificador");
        }
    }
}
