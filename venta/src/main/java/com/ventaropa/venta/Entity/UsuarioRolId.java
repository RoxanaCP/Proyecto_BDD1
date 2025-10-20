package com.ventaropa.venta.Entity;

import java.io.Serializable;
import java.util.Objects;

// Clase para clave primaria compuesta (en archivo separado o en el mismo archivo)

class UsuarioRolId implements Serializable {

    private Integer idUsuario;
    private Integer idRol;

    public UsuarioRolId() {}

    public UsuarioRolId(Integer idUsuario, Integer idRol) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioRolId)) return false;
        UsuarioRolId that = (UsuarioRolId) o;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(idRol, that.idRol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idRol);
    }
}

