package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MARCA_PRODUCTO")
public class MarcaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marcaProducto_seq")
    @SequenceGenerator(name = "marcaProducto_seq", sequenceName = "MARCA_PRODUCTO_SEQ", allocationSize = 1)
    @Column(name = "IDMARCAPRODUCTO")
    private Integer idMarcaProducto;

    @Column(name = "IDMARCA", nullable = false)
    private Integer idMarca;

    @Column(name = "IDPRODUCTO", nullable = false)
    private Integer idProducto;

    // Getters y Setters

    public Integer getIdMarcaProducto() {
        return idMarcaProducto;
    }

    public void setIdMarcaProducto(Integer idMarcaProducto) {
        this.idMarcaProducto = idMarcaProducto;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}

