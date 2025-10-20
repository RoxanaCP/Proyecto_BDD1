package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_MOVIMIENTO")
public class TipoMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_movimiento_seq")
    @SequenceGenerator(name = "tipo_movimiento_seq", sequenceName = "TIPO_MOVIMIENTO_SEQ", allocationSize = 1)
    @Column(name = "IDTIPOMOVIMIENTO")
    private Integer idTipoMovimiento;

    @Lob
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    // Getters y Setters

    public Integer getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(Integer idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
