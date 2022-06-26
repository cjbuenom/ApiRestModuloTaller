package com.example.ModuloTallersf.service.impl;

import com.example.ModuloTallersf.dto.FiltroClienteDTO;
import com.example.ModuloTallersf.exception.ModelNotFoundException;
import com.example.ModuloTallersf.model.InformeOrdenServicio;
import com.example.ModuloTallersf.repository.InformeOrdenServicioRepository;
import com.example.ModuloTallersf.service.InformeOdenServicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InformeOrdenServicioServiceImpl implements InformeOdenServicioService {

    private final InformeOrdenServicioRepository informeOrdenServicioRepository;

    @Autowired
    public InformeOrdenServicioServiceImpl(InformeOrdenServicioRepository informeOrdenServicioRepository) {
        this.informeOrdenServicioRepository = informeOrdenServicioRepository;
    }


    @Override
    public List<InformeOrdenServicio> findAll() {
        return informeOrdenServicioRepository.findAll();
    }

    @Override
    public InformeOrdenServicio leerPorId(Integer id) {
            Optional<InformeOrdenServicio> informe = informeOrdenServicioRepository.findById(id);

            if (id != (int)id){
                throw new ModelNotFoundException("Error al encontrar al Informe" + id);
            }
            if(informe.isPresent()){
                return informe.get();
            }else{
                throw new ModelNotFoundException("Error al encontrar al Informe");
            }
    }



    @Override
    public InformeOrdenServicio save(InformeOrdenServicio informeOrdenServicioCurrent) {
        return informeOrdenServicioRepository.save(informeOrdenServicioCurrent);
    }

    @Override
    public InformeOrdenServicio modificar(InformeOrdenServicio obj) {
        return informeOrdenServicioRepository.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        informeOrdenServicioRepository.deleteById(id);
        return true;
    }

    @Override
    public List<FiltroClienteDTO> listarCliente() {
        List<FiltroClienteDTO> clientes = new ArrayList<>();

        informeOrdenServicioRepository.listarCliente().forEach(x -> {
            FiltroClienteDTO cr = new FiltroClienteDTO();
            cr.setNroOrdenServicio(String.valueOf(x[4]));
            cr.setIdDetalleInforme(Integer.parseInt(String.valueOf(x[0])));
            cr.setIdCliente(Integer.parseInt(String.valueOf(x[7])));
            clientes.add(cr);
        });
        return clientes;
    }
}
