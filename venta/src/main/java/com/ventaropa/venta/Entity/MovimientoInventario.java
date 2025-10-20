package com.ventaropa.venta.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MOVIMIENTO_INVENTARIO")
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimientoInventario_seq")
    @SequenceGenerator(name = "movimientoInventario_seq", sequenceName = "MOVIMIENTO_INVENTARIO_SEQ", allocationSize = 1)
    @Column(name = "IDMOVIMIENTOINVENTARIO")
    private Integer idMovimientoInventario;

    @Column(name = "IDBODEGA", nullable = false)
    private Integer idBodega;

    @Column(name = "IDTIPOMOVIMIENTO", nullable = false)
    private Integer idTipoMovimiento;

    @Column(name = "IDPRODUCTO", nullable = false)
    private Integer idProducto;

    @Column(name = "CANTIDADPRODUCTO", nullable = false)
    private Integer cantidadProducto;

    @Column(name = "FECHAMOVIMIENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaMovimiento;

    // Getters y Setters

    public Integer getIdMovimientoInventario() {
        return idMovimientoInventario;
    }

    public void setIdMovimientoInventario(Integer idMovimientoInventario) {
        this.idMovimientoInventario = idMovimientoInventario;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(Integer idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }
}
