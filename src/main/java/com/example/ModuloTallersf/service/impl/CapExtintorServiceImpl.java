package com.example.ModuloTallersf.service.impl;

import com.example.ModuloTallersf.exception.ModelNotFoundException;
import com.example.ModuloTallersf.model.CapacidadExtintor;
import com.example.ModuloTallersf.model.Certificadores;
import com.example.ModuloTallersf.repository.CapExtintorRepository;
import com.example.ModuloTallersf.service.CapExtintorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapExtintorServiceImpl implements CapExtintorService {

    private final CapExtintorRepository capextintorrepository;

    @Autowired
    public CapExtintorServiceImpl(CapExtintorRepository capextintorrepository) {
        this.capextintorrepository = capextintorrepository;
    }

    @Override
    public List<CapacidadExtintor> findAll() {
        return capextintorrepository.findAll();
    }

    @Override
    public CapacidadExtintor save(CapacidadExtintor capacidadExtintor) {
        return capextintorrepository.save(capacidadExtintor);
    }

    @Override
    public CapacidadExtintor modificar(CapacidadExtintor obj) {
        return capextintorrepository.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        capextintorrepository.deleteById(id);
        return true;
    }

    @Override
    public CapacidadExtintor leerPorId(Integer id) throws ModelNotFoundException {
        Optional<CapacidadExtintor> capextintor = capextintorrepository.findById(id);
        if(capextintor.isPresent()){
            return capextintor.get();
        }else{
            throw new ModelNotFoundException("Error al encontrar al capacidad extintor");
        }
    }

}
