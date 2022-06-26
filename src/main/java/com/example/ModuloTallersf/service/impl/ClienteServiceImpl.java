package com.example.ModuloTallersf.service.impl;


import com.example.ModuloTallersf.exception.ModelNotFoundException;
import com.example.ModuloTallersf.model.Cliente;
import com.example.ModuloTallersf.repository.ClienteRepository;
import com.example.ModuloTallersf.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteServiceImpl implements ClienteService {


    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente clientCurrent) {
        return clienteRepository.save(clientCurrent);
    }

    @Override
    public Cliente modificar(Cliente obj) {
        return clienteRepository.save(obj);
    }

    @Override
    public boolean eliminar(Integer id) {
        clienteRepository.deleteById(id);
        return true;
    }

    @Override
    public Cliente leerPorId(Integer id) throws ModelNotFoundException {
        Optional<Cliente> client = clienteRepository.findById(id);
        if(client.isPresent()){
            return client.get();
        }else{
            throw new ModelNotFoundException("Error al encontrar al cliente");
        }
    }

}
