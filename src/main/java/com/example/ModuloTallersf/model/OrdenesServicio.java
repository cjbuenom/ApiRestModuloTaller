package com.example.ModuloTallersf.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "ordeneservicio")
public class OrdenesServicio {

//    @Id
//    @GeneratedValue(strategy =  GenerationType.IDENTITY)
//    @Column (name ="idOrdenServ")
//    private Integer idOrdenServ;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name ="IdDetalleServicio")
    private Integer IdDetalleServicio;


    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false, foreignKey = @ForeignKey(name = "FKidCliente"))
    private Cliente cliente;

    @Size(min = 3, max = 50, message = "Numero de Orden debe tener minimo 3 caracteres")
    @Column(name = "nroRden", nullable = true, length = 50)
    private String nroRden;

    @Size(min = 3, max = 50, message = "Fecha Ingreso debe tener minimo 3 caracteres")
    @Column(name = "FechaIngress", nullable = true, length = 50)
    private String FechaIngress;

    @Size(min = 3, max = 50, message = "Fecha Egreso debe tener minimo 3 caracteres")
    @Column(name = "FechaEgress", nullable = true, length = 50)
    private String FechaEgress;


    public Integer getIdDetalleServicio() {
        return IdDetalleServicio;
    }

    public void setIdDetalleServicio(Integer idDetalleServicio) {
        IdDetalleServicio = idDetalleServicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNroRden() {
        return nroRden;
    }

    public void setNroRden(String nroRden) {
        this.nroRden = nroRden;
    }

    public String getFechaIngress() {
        return FechaIngress;
    }

    public void setFechaIngress(String fechaIngress) {
        FechaIngress = fechaIngress;
    }

    public String getFechaEgress() {
        return FechaEgress;
    }

    public void setFechaEgress(String fechaEgress) {
        FechaEgress = fechaEgress;
    }
}
