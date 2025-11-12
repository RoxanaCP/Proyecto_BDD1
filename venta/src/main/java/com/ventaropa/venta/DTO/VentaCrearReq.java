package com.ventaropa.venta.DTO;

import java.util.List;

public class VentaCrearReq {
    private Integer idCliente;
    private Integer idTipoVenta;
    private Integer idTipoPago;           // Mantener para compatibilidad
    private Integer idSucursal;
    private List<Det> detalle;

    // Nueva propiedad para pagos múltiples
    private List<PagoReq> pagos;

    // Getters & Setters
    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public Integer getIdTipoVenta() { return idTipoVenta; }
    public void setIdTipoVenta(Integer idTipoVenta) { this.idTipoVenta = idTipoVenta; }

    public Integer getIdTipoPago() { return idTipoPago; }
    public void setIdTipoPago(Integer idTipoPago) { this.idTipoPago = idTipoPago; }

    public Integer getIdSucursal() { return idSucursal; }
    public void setIdSucursal(Integer idSucursal) { this.idSucursal = idSucursal; }

    public List<Det> getDetalle() { return detalle; }
    public void setDetalle(List<Det> detalle) { this.detalle = detalle; }

    public List<PagoReq> getPagos() { return pagos; }
    public void setPagos(List<PagoReq> pagos) { this.pagos = pagos; }

    // Detalle de productos
    public static class Det {
        private Integer idProducto;
        private Integer cantidad;

        public Integer getIdProducto() { return idProducto; }
        public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

        public Integer getCantidad() { return cantidad; }
        public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    }
}
