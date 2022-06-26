package com.example.ModuloTallersf.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UserSys {

    @Id
    @Column (name ="idUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;



    @Size(min = 1, max = 75, message = "nombre debe tener 1 caracteres")
    @Column(name = "nombre" ,nullable = false)
    private String nombre;


    @Size(min = 1, max = 180, message = "clave debe tener 1 caracteres")
    @Column(name = "clave" ,nullable = false)
    private String clave;



    @Size(min = 1, max = 15, message = "estado debe tener 1 caracteres")
    @Column(name = "estado" ,nullable = false)
    private String estado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
    private List<roles> roles;


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<com.example.ModuloTallersf.model.roles> getRoles() {
        return roles;
    }

    public void setRoles(List<com.example.ModuloTallersf.model.roles> roles) {
        this.roles = roles;
    }
}
