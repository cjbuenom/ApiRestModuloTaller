package com.example.ModuloTallersf.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "capacidadextintor")
public class CapacidadExtintor {

    @ApiModelProperty(notes = "Id de capacidad debe tener como minimo 1 caracteres")
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name ="IdCapacidad")
    private Integer IdCapacidad;

    @ApiModelProperty(notes = "cantidad debe tener como minimo 3 caracteres")
    @Size(min = 3, max = 8, message = " debe tener minimo 3 caracteres")
    @Column(name = "capacidad", nullable = false, length = 8)
    private String cantidad;

    public Integer getIdCapacidad() {
        return IdCapacidad;
    }

    public void setIdCapacidad(Integer idCapacidad) {
        IdCapacidad = idCapacidad;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
