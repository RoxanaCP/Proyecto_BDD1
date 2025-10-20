package com.ventaropa.venta.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BITACORA")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bitacora_seq")
    @SequenceGenerator(name = "bitacora_seq", sequenceName = "BITACORA_SEQ", allocationSize = 1)
    @Column(name = "IDBITACORA")
    private Integer idBitacora;

    @Column(name = "IDUSUARIO", nullable = false)
    private Integer idUsuario;

    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Lob
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @Lob
    @Column(name = "ACCION", nullable = false)
    private String accion;

    public Integer getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
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

    
}
