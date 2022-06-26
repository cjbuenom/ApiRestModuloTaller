package com.example.ModuloTallersf.dto;

import com.example.ModuloTallersf.model.Cliente;
import com.example.ModuloTallersf.model.InformeOrdenServicio;
import com.example.ModuloTallersf.model.OrdenesServicio;

import javax.persistence.Id;

public class FiltroClienteDTO {


    private Integer IdCliente;
    private String NroOrdenServicio;

    private Integer IdDetalleInforme;

    public FiltroClienteDTO(){}

    public FiltroClienteDTO (String NroOrdenServicio, Integer IdDetalleInforme, Integer IdCliente ){
        super();
        this.NroOrdenServicio = NroOrdenServicio;
        this.IdDetalleInforme = IdDetalleInforme;
        this.IdCliente = IdCliente;
    }


    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer idCliente) {
        IdCliente = idCliente;
    }

    public String getNroOrdenServicio() {
        return NroOrdenServicio;
    }

    public void setNroOrdenServicio(String nroOrdenServicio) {
        NroOrdenServicio = nroOrdenServicio;
    }

    public Integer getIdDetalleInforme() {
        return IdDetalleInforme;
    }

    public void setIdDetalleInforme(Integer idDetalleInforme) {
        IdDetalleInforme = idDetalleInforme;
    }
}
