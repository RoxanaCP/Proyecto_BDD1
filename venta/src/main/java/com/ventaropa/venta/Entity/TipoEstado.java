package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_ESTADO")
public class TipoEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_estado_seq")
    @SequenceGenerator(name = "tipo_estado_seq", sequenceName = "TIPO_ESTADO_SEQ", allocationSize = 1)
    @Column(name = "IDTIPOESTADO")
    private Integer idTipoEstado;

    @Lob
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    // Getters y Setters

    public Integer getIdTipoEstado() {
        return idTipoEstado;
    }

    public void setIdTipoEstado(Integer idTipoEstado) {
        this.idTipoEstado = idTipoEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
