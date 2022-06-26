package com.example.ModuloTallersf.service;

import com.example.ModuloTallersf.dto.FiltroClienteDTO;
import com.example.ModuloTallersf.model.InformeOrdenServicio;

import java.util.List;

public interface InformeOdenServicioService extends ICRUD<InformeOrdenServicio>{



    List<FiltroClienteDTO> listarCliente();

    interface UsuarioService {
    }
}
