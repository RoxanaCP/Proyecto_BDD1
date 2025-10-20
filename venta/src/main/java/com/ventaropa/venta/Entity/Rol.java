package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ROL")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_seq")
    @SequenceGenerator(name = "rol_seq", sequenceName = "ROL_SEQ", allocationSize = 1)
    @Column(name = "IDROL")
    private Integer idRol;

    @Lob
    @Column(name = "NOMBREROL", nullable = false)
    private String nombreRol;

    // Getters y Setters

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
