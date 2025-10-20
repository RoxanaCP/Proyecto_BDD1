package com.ventaropa.venta.Entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FACTURA_VENTA")
public class FacturaVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facturaVenta_seq")
    @SequenceGenerator(name = "facturaVenta_seq", sequenceName = "FACTURA_VENTA_SEQ", allocationSize = 1)
    @Column(name = "IDFACTURAVENTA")
    private Integer idFacturaVenta;

    @Column(name = "IDPAGO", nullable = false)
    private Integer idPago;

    @Column(name = "IDTIPOVENTA", nullable = false)
    private Integer idTipoVenta;

    @Column(name = "IDEMPLEADO", nullable = false)
    private Integer idEmpleado;

    @Column(name = "IDSUCURSAL", nullable = false)
    private Integer idSucursal;

    @Column(name = "IDCLIENTE", nullable = false)
    private Integer idCliente;

    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "TOTAL", nullable = false)
    private Integer total;

    // Getters y Setters

    public Integer getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(Integer idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdTipoVenta() {
        return idTipoVenta;
    }

    public void setIdTipoVenta(Integer idTipoVenta) {
        this.idTipoVenta = idTipoVenta;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
