package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_VENTA")
public class TipoVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_venta_seq")
    @SequenceGenerator(name = "tipo_venta_seq", sequenceName = "TIPO_VENTA_SEQ", allocationSize = 1)
    @Column(name = "IDTIPOVENTA")
    private Integer idTipoVenta;

    @Lob
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    // Getters y Setters

    public Integer getIdTipoVenta() {
        return idTipoVenta;
    }

    public void setIdTipoVenta(Integer idTipoVenta) {
        this.idTipoVenta = idTipoVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
