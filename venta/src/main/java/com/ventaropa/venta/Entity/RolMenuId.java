package com.ventaropa.venta.Entity;

import java.io.Serializable;
import java.util.Objects;

// Clase para la clave compuesta

class RolMenuId implements Serializable {

    private Integer idMenu;
    private Integer idRol;

    public RolMenuId() {}

    public RolMenuId(Integer idMenu, Integer idRol) {
        this.idMenu = idMenu;
        this.idRol = idRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolMenuId)) return false;
        RolMenuId that = (RolMenuId) o;
        return Objects.equals(idMenu, that.idMenu) && Objects.equals(idRol, that.idRol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMenu, idRol);
    }
}

