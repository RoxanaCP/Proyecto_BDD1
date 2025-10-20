package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DETALLE__FACTURA")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalleFactura_seq")
    @SequenceGenerator(name = "detalleFactura_seq", sequenceName = "DETALLE_FACTURA_SEQ", allocationSize = 1)
    @Column(name = "IDDETFACT")
    private Integer idDetFact;

    @Column(name = "IDPRODUCTO", nullable = false)
    private Integer idProducto;

    @Column(name = "IDFACTURAVENTA", nullable = false)
    private Integer idFacturaVenta;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @Column(name = "PRECIOUNITARIO", nullable = false)
    private Integer precioUnitario;

    // Getters y Setters

    public Integer getIdDetFact() {
        return idDetFact;
    }

    public void setIdDetFact(Integer idDetFact) {
        this.idDetFact = idDetFact;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(Integer idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}

