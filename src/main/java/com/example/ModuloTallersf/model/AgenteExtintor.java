package com.example.ModuloTallersf.model;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name ="agentextintor")
public class AgenteExtintor {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name ="IdAgente")
    private Integer IdAgente;

    @Size(min = 3, max = 50, message = "Nombre agente Certificador debe tener minimo 3 caracteres")
    @Column(name = "Nombre", nullable = false, length = 50)
    private String Nombre;

    public Integer getIdAgente() {
        return IdAgente;
    }

    public void setIdAgente(Integer idAgente) {
        IdAgente = idAgente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
