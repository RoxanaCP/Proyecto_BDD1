package com.ventaropa.venta.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PERSONA")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    @SequenceGenerator(name = "persona_seq", sequenceName = "PERSONA_SEQ", allocationSize = 1)
    @Column(name = "IDPERSONA")
    private Integer idPersona;

    @Column(name = "IDPAIS", nullable = false)
    private Integer idPais;

    @Lob
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Lob
    @Column(name = "GENERO", nullable = false)
    private String genero;

    @Column(name = "FECHANACIMIENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "TELEFONO", nullable = false)
    private Long telefono;

    // Getters y Setters

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
}
