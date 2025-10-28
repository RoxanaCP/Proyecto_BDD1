// src/main/java/com/ventaropa/venta/DTO/VentaDetalleReq.java
package com.ventaropa.venta.DTO;

import java.math.BigDecimal;

public class VentaDetalleReq {
    private Integer idProducto;
    private Integer cantidad;
    private BigDecimal precioUnitario; // puede venir null; el service pone default

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
}
