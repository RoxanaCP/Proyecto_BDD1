package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CENTRO_COMERCIAL")
public class CentroComercial {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "centroComercial_seq")
    @SequenceGenerator(name = "centroComercial_seq", sequenceName = "CENTRO_COMERCIAL_SEQ", allocationSize = 1)
    @Column(name = "IDCENTROCOMERCIAL")
    private Integer idCentroComercial;

    @Lob
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Lob
    @Column(name = "UBICACION", nullable = false)
    private String ubicacion;

    // Getters y Setters

    public Integer getIdCentroComercial() {
        return idCentroComercial;
    }

    public void setIdCentroComercial(Integer idCentroComercial) {
        this.idCentroComercial = idCentroComercial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
