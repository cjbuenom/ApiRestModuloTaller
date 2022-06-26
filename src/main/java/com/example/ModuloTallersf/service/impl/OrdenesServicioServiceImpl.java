package com.example.ModuloTallersf.service.impl;

import com.example.ModuloTallersf.exception.ModelNotFoundException;
import com.example.ModuloTallersf.model.InformeOrdenServicio;
import com.example.ModuloTallersf.model.OrdenesServicio;
import com.example.ModuloTallersf.repository.OrdenesServiciorepository;
import com.example.ModuloTallersf.service.OrdeneServicioService;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenesServicioServiceImpl implements OrdeneServicioService {

    private final OrdenesServiciorepository ordenesServiciorepository;


    public OrdenesServicioServiceImpl(OrdenesServiciorepository ordenesServiciorepository) {
        this.ordenesServiciorepository = ordenesServiciorepository;
    }


    @Override
    public List<OrdenesServicio> findAll() {
        return ordenesServiciorepository.findAll();
    }

    @Override
    public OrdenesServicio leerPorId(Integer id) throws ModelNotFoundException {
        Optional<OrdenesServicio> ordenes = ordenesServiciorepository.findById(id);
        if(ordenes.isPresent()){
            return ordenes.get();
        }else{
            throw new ModelNotFoundException("Error al encontrar al ordenes");
        }
    }


    @Override
    public OrdenesServicio save(OrdenesServicio ordenesServicioCurrent) {
        return ordenesServiciorepository.save(ordenesServicioCurrent);
    }

    @Override
    public OrdenesServicio modificar(OrdenesServicio obj) {
        return ordenesServiciorepository.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        ordenesServiciorepository.deleteById(id);
        return true;
    }
}
