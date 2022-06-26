package com.example.ModuloTallersf.service.impl;

import com.example.ModuloTallersf.exception.ModelNotFoundException;
import com.example.ModuloTallersf.model.AgenteExtintor;
import com.example.ModuloTallersf.model.CapacidadExtintor;
import com.example.ModuloTallersf.repository.AgenteExtintorRepository;
import com.example.ModuloTallersf.service.AgenteExtintorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenteExtintorServiceImpl implements AgenteExtintorService {

    private final AgenteExtintorRepository agenteExtintorRepository;

    @Autowired
    public AgenteExtintorServiceImpl(AgenteExtintorRepository agenteExtintorRepository) {
        this.agenteExtintorRepository = agenteExtintorRepository;
    }

    @Override
    public List<AgenteExtintor> findAll() {
        return agenteExtintorRepository.findAll();
    }

    @Override
    public AgenteExtintor save(AgenteExtintor agenteExtintorCurrent) {
        return agenteExtintorRepository.save(agenteExtintorCurrent);
    }

    @Override
    public AgenteExtintor modificar(AgenteExtintor obj) {
        return agenteExtintorRepository.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        agenteExtintorRepository.deleteById(id);
        return true;
    }

    @Override
    public AgenteExtintor leerPorId(Integer id) throws ModelNotFoundException {
        Optional<AgenteExtintor> agenteExtintor = agenteExtintorRepository.findById(id);
        if(agenteExtintor.isPresent()){
            return agenteExtintor.get();
        }else{
            throw new ModelNotFoundException("Error al encontrar al agente Extintor");
        }
    }
}
