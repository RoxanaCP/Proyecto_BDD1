package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "INVENTARIO")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventario_seq")
    @SequenceGenerator(name = "inventario_seq", sequenceName = "INVENTARIO_SEQ", allocationSize = 1)
    @Column(name = "IDINVENTARIO")
    private Integer idInventario;

    @Column(name = "IDPRODUCTO", nullable = false)
    private Integer idProducto;

    @Column(name = "IDBODEGA", nullable = false)
    private Integer idBodega;

    @Column(name = "EXISTENCIAPRODUCTO", nullable = false)
    private Integer existenciaProducto;

    // Getters y Setters

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getExistenciaProducto() {
        return existenciaProducto;
    }

    public void setExistenciaProducto(Integer existenciaProducto) {
        this.existenciaProducto = existenciaProducto;
    }
}
