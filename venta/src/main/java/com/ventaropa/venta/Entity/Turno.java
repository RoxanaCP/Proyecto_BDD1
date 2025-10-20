package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TURNO")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_seq")
    @SequenceGenerator(name = "turno_seq", sequenceName = "TURNO_SEQ", allocationSize = 1)
    @Column(name = "IDTURNO")
    private Integer idTurno;

    @Lob
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    // Getters y Setters

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
