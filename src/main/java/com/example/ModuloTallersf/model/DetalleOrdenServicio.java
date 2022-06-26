package com.example.ModuloTallersf.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "detalleordenservicio")
public class DetalleOrdenServicio {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name ="idextintor")
    private Integer idextintor;

    @ManyToOne
    @JoinColumn(name = "IdDetalleServicio", nullable = false, foreignKey = @ForeignKey(name = "FKIdDetalleServicio"))
    private OrdenesServicio ordenesServicio;

    @ManyToOne
    @JoinColumn(name = "IdCapacidad", nullable = false, foreignKey = @ForeignKey(name = "FKIdCapacidad"))
    private CapacidadExtintor capacidadextintor;

    @ManyToOne
    @JoinColumn(name = "IdAgente", nullable = false, foreignKey = @ForeignKey(name = "FKIdAgente"))
    private AgenteExtintor agentextintor;

    @ManyToOne
    @JoinColumn(name = "IdCertificador", nullable = false, foreignKey = @ForeignKey(name = "FKIdCertificador"))
    private Certificadores certificadores;

    @Size(min = 3, max = 150, message = "Numero Certificacion debe tener minimo 3 caracteres")
    @Column(name = "NroCertifi", nullable = true, length = 150)
    private String NroCertifi;

//    @ManyToOne
//    @JoinColumn(name = "idtrabajo", nullable = false, foreignKey = @ForeignKey(name = "FKIdTrabajo"))
//    private Trabajos trabajos;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TrabajosPorDetalleDeOrden", joinColumns = @JoinColumn(name = "idextintor", referencedColumnName = "idextintor"), inverseJoinColumns = @JoinColumn(name = "idtrabajo", referencedColumnName = "idtrabajo"))
    private List<Trabajos> trabajos;


    public Integer getIdextintor() {
        return idextintor;
    }

    public void setIdextintor(Integer idextintor) {
        this.idextintor = idextintor;
    }

    public OrdenesServicio getOrdenesServicio() {
        return ordenesServicio;
    }

    public void setOrdenesServicio(OrdenesServicio ordenesServicio) {
        this.ordenesServicio = ordenesServicio;
    }

    public CapacidadExtintor getCapacidadextintor() {
        return capacidadextintor;
    }

    public void setCapacidadextintor(CapacidadExtintor capacidadextintor) {
        this.capacidadextintor = capacidadextintor;
    }

    public AgenteExtintor getAgentextintor() {
        return agentextintor;
    }

    public void setAgentextintor(AgenteExtintor agentextintor) {
        this.agentextintor = agentextintor;
    }

    public Certificadores getCertificadores() {
        return certificadores;
    }

    public void setCertificadores(Certificadores certificadores) {
        this.certificadores = certificadores;
    }

    public String getNroCertifi() {
        return NroCertifi;
    }

    public void setNroCertifi(String nroCertifi) {
        NroCertifi = nroCertifi;
    }

    public List<Trabajos> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(List<Trabajos> trabajos) {
        this.trabajos = trabajos;
    }
}
