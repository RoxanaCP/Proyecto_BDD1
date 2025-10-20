package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PAIS")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pais_seq")
    @SequenceGenerator(name = "pais_seq", sequenceName = "PAIS_SEQ", allocationSize = 1)
    @Column(name = "IDPAIS")
    private Integer idPais;

    @Lob
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    // Getters y Setters

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
