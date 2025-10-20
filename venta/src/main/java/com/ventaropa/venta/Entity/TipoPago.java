package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_PAGO")
public class TipoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_pago_seq")
    @SequenceGenerator(name = "tipo_pago_seq", sequenceName = "TIPO_PAGO_SEQ", allocationSize = 1)
    @Column(name = "IDTIPOPAGO")
    private Integer idTipoPago;

    @Lob
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    // Getters y Setters

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
