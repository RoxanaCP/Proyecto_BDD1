package com.ventaropa.venta.DTO;

import java.util.Date;

public class FacturaVentaDTO {
    
    private Integer idFacturaVenta;
    private Integer pago;
    private String tipoVenta;
    private String empleado;
    private String sucursal;
    private String cliente;
    private Date fecha;
    private Integer total;

    public FacturaVentaDTO(Integer idFacturaVenta, Integer pago, String tipoVenta, String empleado,
                           String sucursal, String cliente, Date fecha, Integer total) {
        this.idFacturaVenta = idFacturaVenta;
        this.pago = pago;
        this.tipoVenta = tipoVenta;
        this.empleado = empleado;
        this.sucursal = sucursal;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
    }

    // Getters y Setters
    public Integer getIdFacturaVenta() { return idFacturaVenta; }
    public void setIdFacturaVenta(Integer idFacturaVenta) { this.idFacturaVenta = idFacturaVenta; }

    public Integer getPago() { return pago; }
    public void setPago(Integer pago) { this.pago = pago; }

    public String getTipoVenta() { return tipoVenta; }
    public void setTipoVenta(String tipoVenta) { this.tipoVenta = tipoVenta; }

    public String getEmpleado() { return empleado; }
    public void setEmpleado(String empleado) { this.empleado = empleado; }

    public String getSucursal() { return sucursal; }
    public void setSucursal(String sucursal) { this.sucursal = sucursal; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }
}
