package com.example.ModuloTallersf.service.impl;

import com.example.ModuloTallersf.exception.ModelNotFoundException;
import com.example.ModuloTallersf.model.DetalleOrdenServicio;
import com.example.ModuloTallersf.model.Trabajos;
import com.example.ModuloTallersf.repository.DetalleOrdenRepository;
import com.example.ModuloTallersf.service.DetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService {


    private final DetalleOrdenRepository detalleOrdenRepository;

    @Autowired
    public DetalleOrdenServiceImpl(DetalleOrdenRepository detalleOrdenRepository) {
        this.detalleOrdenRepository = detalleOrdenRepository;
    }


    @Override
    public List<DetalleOrdenServicio> findAll() {
        return detalleOrdenRepository.findAll();
    }

    @Override
    public DetalleOrdenServicio save(DetalleOrdenServicio detalleOrderserCurrent) {
        return detalleOrdenRepository.save(detalleOrderserCurrent);
    }

    @Override
    public DetalleOrdenServicio modificar(DetalleOrdenServicio obj) {
        return detalleOrdenRepository.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        detalleOrdenRepository.deleteById(id);
        return true;
    }

    @Override
    public DetalleOrdenServicio leerPorId(Integer id) throws ModelNotFoundException {
        Optional<DetalleOrdenServicio> detalleOrden = detalleOrdenRepository.findById(id);
        if(detalleOrden.isPresent()){
            return detalleOrden.get();
        }else{
            throw new ModelNotFoundException("Error al encontrar al detalleOrden");
        }
    }


}
