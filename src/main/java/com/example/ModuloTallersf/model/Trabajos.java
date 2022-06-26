package com.example.ModuloTallersf.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name ="trabajos")
public class Trabajos {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name ="idtrabajo")
    private Integer idtrabajo;

    @Size(min = 1, max = 5, message = "Letra Indice TrabajosController debe tener minimo 1 caracteres")
    @Column(name = "LetraIndext", nullable = true, length = 5)
    private String LetraIndext;

    @Size(min = 3, max = 40, message = "Descripcion debe tener minimo 3 caracteres")
    @Column(name = "Descripcion", nullable = true, length = 40)
    private String Descripcion;

    public Integer getIdtrabajo() {
        return idtrabajo;
    }

    public void setIdtrabajo(Integer idtrabajo) {
        this.idtrabajo = idtrabajo;
    }

    public String getLetraIndext() {
        return LetraIndext;
    }

    public void setLetraIndext(String letraIndext) {
        LetraIndext = letraIndext;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
