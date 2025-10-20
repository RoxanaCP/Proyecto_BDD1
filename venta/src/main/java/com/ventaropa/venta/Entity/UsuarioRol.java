package com.ventaropa.venta.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "USUARIO_ROL")
@IdClass(UsuarioRolId.class)
public class UsuarioRol {

    @Id
    @Column(name = "IDUSUARIO", nullable = false)
    private Integer idUsuario;

    @Id
    @Column(name = "IDROL", nullable = false)
    private Integer idRol;

    // Getters y Setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
}

