package com.ventaropa.venta.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PAGO")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pago_seq")
    @SequenceGenerator(name = "pago_seq", sequenceName = "PAGO_SEQ", allocationSize = 1)
    @Column(name = "IDPAGO")
    private Integer idPago;

    @Column(name = "IDTIPOPAGO", nullable = false)
    private Integer idTipoPago;

    @Column(name = "MONTO", nullable = false, precision = 10, scale = 4)
    private BigDecimal monto;

    // Getters y Setters

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
