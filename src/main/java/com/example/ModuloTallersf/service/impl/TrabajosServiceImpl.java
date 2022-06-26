package com.example.ModuloTallersf.service.impl;

import com.example.ModuloTallersf.exception.ModelNotFoundException;
import com.example.ModuloTallersf.model.OrdenesServicio;
import com.example.ModuloTallersf.model.Trabajos;
import com.example.ModuloTallersf.repository.TrabajosRepository;
import com.example.ModuloTallersf.service.TrabajosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajosServiceImpl implements TrabajosService {

    private final TrabajosRepository trabajosRepository;

    @Autowired
    public TrabajosServiceImpl(TrabajosRepository trabajosRepository) {
        this.trabajosRepository = trabajosRepository;
    }


    @Override
    public List<Trabajos> findAll() {
        return trabajosRepository.findAll();
    }

    @Override
    public Trabajos leerPorId(Integer id) throws ModelNotFoundException {
        Optional<Trabajos> trabajos = trabajosRepository.findById(id);
        if(trabajos.isPresent()){
            return trabajos.get();
        }else{
            throw new ModelNotFoundException("Error al encontrar al trabajos");
        }
    }

    @Override
    public Trabajos save(Trabajos trabajoCurrent) {
        return trabajosRepository.save(trabajoCurrent);
    }

    @Override
    public Trabajos modificar(Trabajos obj) {
        return trabajosRepository.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        trabajosRepository.deleteById(id);
        return true;
    }
}
