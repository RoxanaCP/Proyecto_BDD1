package com.ventaropa.venta.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ESTADO_ENVIO")
public class EstadoEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estadoEnvio_seq")
    @SequenceGenerator(name = "estadoEnvio_seq", sequenceName = "ESTADO_ENVIO_SEQ", allocationSize = 1)
    @Column(name = "IDESTADOENVIO")
    private Integer idEstadoEnvio;

    @Column(name = "IDFACTURAVENTA", nullable = false)
    private Integer idFacturaVenta;

    @Column(name = "IDTIPOESTADO", nullable = false)
    private Integer idTipoEstado;

    @Column(name = "FECHAENVIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;

    @Column(name = "FECHAENTREGA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;

    @Lob
    @Column(name = "DIRECCIONENTREGA", nullable = false)
    private String direccionEntrega;

    // Getters y Setters

    public Integer getIdEstadoEnvio() {
        return idEstadoEnvio;
    }

    public void setIdEstadoEnvio(Integer idEstadoEnvio) {
        this.idEstadoEnvio = idEstadoEnvio;
    }

    public Integer getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(Integer idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public Integer getIdTipoEstado() {
        return idTipoEstado;
    }

    public void setIdTipoEstado(Integer idTipoEstado) {
        this.idTipoEstado = idTipoEstado;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
}
