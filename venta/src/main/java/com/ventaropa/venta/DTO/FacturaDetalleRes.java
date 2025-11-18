package com.ventaropa.venta.DTO;

import java.util.List;

public class FacturaDetalleRes {

    private Integer idFactura;
    private String cliente;
    private String tipoVenta;
    private String fecha;
    private double total;

    private List<ItemDetalle> detalles;
    private List<ItemPago> pagos;   // <-- IMPORTANTE

    // ---- GETTERS & SETTERS ----

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<ItemDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ItemDetalle> detalles) {
        this.detalles = detalles;
    }

    public List<ItemPago> getPagos() {
        return pagos;
    }

    public void setPagos(List<ItemPago> pagos) {
        this.pagos = pagos;
    }


    // ======================================
    //         SUBCLASES DETALLE Y PAGO
    // ======================================

    public static class ItemDetalle {
        private Integer idProducto;
        private String nombre;
        private Integer cantidad;
        private double precioUnitario;
        private double subtotal;

        public Integer getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(Integer idProducto) {
            this.idProducto = idProducto;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }

        public double getPrecioUnitario() {
            return precioUnitario;
        }

        public void setPrecioUnitario(double precioUnitario) {
            this.precioUnitario = precioUnitario;
        }

        public double getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(double subtotal) {
            this.subtotal = subtotal;
        }
    }


    public static class ItemPago {
        private Integer idTipoPago;
        private String tipoPago;
        private double monto;

        public Integer getIdTipoPago() {
            return idTipoPago;
        }

        public void setIdTipoPago(Integer idTipoPago) {
            this.idTipoPago = idTipoPago;
        }

        public String getTipoPago() {
            return tipoPago;
        }

        public void setTipoPago(String tipoPago) {
            this.tipoPago = tipoPago;
        }

        public double getMonto() {
            return monto;
        }

        public void setMonto(double monto) {
            this.monto = monto;
        }
    }
}
