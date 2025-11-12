package com.ventaropa.venta.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BITACORA")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDBITACORA", nullable = false)
    private Long idBitacora;

    @Column(name = "IDUSUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "DESCRIPCION", nullable = false, columnDefinition = "CLOB")
    private String descripcion;

    @Column(name = "ACCION", nullable = false, columnDefinition = "CLOB")
    private String accion;

    @Column(name = "VALOR_NUEVO")
    private Long valorNuevo;

    @Column(name = "VALOR_ANTERIOR")
    private Long valorAnterior;

    // ---------------------------
    // Getters y Setters
    // ---------------------------

    public Long getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Long idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Long getValorNuevo() {
        return valorNuevo;
    }

    public void setValorNuevo(Long valorNuevo) {
        this.valorNuevo = valorNuevo;
    }

    public Long getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(Long valorAnterior) {
        this.valorAnterior = valorAnterior;
    }
}
