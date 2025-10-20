package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MODULO")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulo_seq")
    @SequenceGenerator(name = "modulo_seq", sequenceName = "MODULO_SEQ", allocationSize = 1)
    @Column(name = "IDMODULO")
    private Integer idModulo;

    @Column(name = "NOMBRE", nullable = false, length = 10)
    private String nombre;

    // Getters y Setters

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

