package com.ventaropa.venta.Entity;

import jakarta.persistence.*;
  
@Entity
@Table(name = "BODEGA")
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bodega_seq")
    @SequenceGenerator(name = "bodega_seq", sequenceName = "BODEGA_SEQ", allocationSize = 1)
    @Column(name = "IDBODEGA")
    private Integer idBodega;

    @Column(name = "IDSUCURSAL", nullable = false)
    private Integer idSucursal;

    @Lob
    @Column(name = "DIRECCION", nullable = false)
    private String direccion;

    // Getters y Setters

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
}
