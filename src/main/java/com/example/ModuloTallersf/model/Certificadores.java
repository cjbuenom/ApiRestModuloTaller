package com.example.ModuloTallersf.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="certificadores")
public class Certificadores {

    @ApiModelProperty(notes = "id certificador debe tener como minimo 1 caracteres")
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name ="IdCertificador")
    private Integer IdCertificador;

    @ApiModelProperty(notes = "nombre debe tener como minimo 3 caracteres")
    @Size(min = 3, max = 50, message = "Nombre Certificador debe tener minimo 3 caracteres")
    @Column(name = "Nombre", nullable = false, length = 50)
    private String Nombre;

    public Integer getIdCertificador() {
        return IdCertificador;
    }

    public void setIdCertificador(Integer idCertificador) {
        IdCertificador = idCertificador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
