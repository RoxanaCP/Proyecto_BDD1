package com.ventaropa.venta.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "USUARIO_SEQ", allocationSize = 1)
    @Column(name = "IDUSUARIO")
    private Integer idUsuario;

    @Column(name = "IDEMPLEADO", nullable = false)
    private Integer idEmpleado;

    @Lob
    @Column(name = "NOMBREUSUARIO", nullable = false)
    private String nombreUsuario;

    @Lob
    @Column(name = "CONTRASENA", nullable = false)
    private String contrasena;

    @Column(name = "ACTIVO", nullable = false)
    private Short activo;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHACREACION", nullable = false)
    private Date fechaCreacion;

    // Getters y Setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
