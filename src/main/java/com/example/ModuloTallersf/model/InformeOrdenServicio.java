package com.example.ModuloTallersf.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@ApiModel(description = "Información o propiedes del Informe de una Orden")
@Table(name="informeOrdenServicio")
public class InformeOrdenServicio {

    @ApiModelProperty(notes = "id debe tener como minimo 1 caracteres")
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name ="IdDetalleInforme")
    private Integer IdDetalleInforme;

    @ApiModelProperty(notes = "cliente debe tener como minimo 3 caracteres")
    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false, foreignKey = @ForeignKey(name = "FKidCliente"))
    private Cliente cliente;


    @ApiModelProperty(notes = "Numero de Orden debe tener como minimo 3 caracteres")
    @Size(min = 3, max = 50, message = "Numero de Orden debe tener minimo 3 caracteres")
    @Column(name = "nroRdenConsultaDetalle", nullable = true, length = 50)

    private String nroRdenConsultaDetalle;
    @ApiModelProperty(notes = "Mes de servicio debe tener como minimo 3 caracteres")
    @Size(min = 3, max = 18, message = "mes en que se realiza el Servicio debe tener minimo 3 caracteres")
    @Column(name = "meServicio", nullable = true, length = 18)
    private String meServicio;

    @ApiModelProperty(notes = "Año de servicio debe tener como minimo 4  caracteres")
    @Size(min = 4, max = 4, message = "año en que se realiza el Servicio debe tener minimo 4 caracteres")
    @Column(name = "AnioServicio", nullable = true, length = 4)
    private String AnioServicio;

    @ApiModelProperty(notes = "Realizado Por debe tener como minimo 10 caracteres")
    @Size(min = 10, max = 50, message = "Nombre de quien Realiza el servicio debe tener minimo 10 caracteres")
    @Column(name = "realizadopor", nullable = true, length = 50)
    private String realizadopor;

    @ApiModelProperty(notes = "Fecha Proxima mantencion debe tener como minimo 2 caracteres")
    @Size(min = 2, max = 20, message = "Fecha de proximo servicio/mantencion debe tener minimo 2 caracteres")
    @Column(name = "fechaProxMantencion", nullable = true, length = 20)
    private String fechaProxMantencion;

    @ApiModelProperty(notes = "Observaciones deBe tener como minimo 1 caracteres")
    @Size(message = "Observaciones para informe servicio/mantencion debe tener minimo 1 caracteres")
    @Column(name = "observacioneService", nullable = true)
    private String observacioneService;

    public Integer getIdDetalleInforme() {
        return IdDetalleInforme;
    }

    public void setIdDetalleInforme(Integer idDetalleInforme) {
        IdDetalleInforme = idDetalleInforme;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNroRdenConsultaDetalle() {
        return nroRdenConsultaDetalle;
    }

    public void setNroRdenConsultaDetalle(String nroRdenConsultaDetalle) {
        this.nroRdenConsultaDetalle = nroRdenConsultaDetalle;
    }

    public String getMeServicio() {
        return meServicio;
    }

    public void setMeServicio(String meServicio) {
        this.meServicio = meServicio;
    }

    public String getAnioServicio() {
        return AnioServicio;
    }

    public void setAnioServicio(String anioServicio) {
        AnioServicio = anioServicio;
    }

    public String getRealizadopor() {
        return realizadopor;
    }

    public void setRealizadopor(String realizadopor) {
        this.realizadopor = realizadopor;
    }

    public String getFechaProxMantencion() {
        return fechaProxMantencion;
    }

    public void setFechaProxMantencion(String fechaProxMantencion) {
        this.fechaProxMantencion = fechaProxMantencion;
    }

    public String getObservacioneService() {
        return observacioneService;
    }

    public void setObservacioneService(String observacioneService) {
        this.observacioneService = observacioneService;
    }
}
