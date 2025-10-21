// src/main/java/com/ventaropa/venta/DTO/MovimientoInventarioReq.java
package com.ventaropa.venta.DTO;

public class MovimientoInventarioReq {
    private Integer idBodega;
    private Integer idTipoMovimiento;
    private Integer idProducto;
    private Integer cantidad;
    private Integer idUsuario;
    private String fecha; // <-- NUEVO, opcional (YYYY-MM-DD)


    public Integer getIdBodega() { return idBodega; }
    public void setIdBodega(Integer idBodega) { this.idBodega = idBodega; }

    public Integer getIdTipoMovimiento() { return idTipoMovimiento; }
    public void setIdTipoMovimiento(Integer idTipoMovimiento) { this.idTipoMovimiento = idTipoMovimiento; }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
