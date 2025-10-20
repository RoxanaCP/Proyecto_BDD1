package com.ventaropa.venta.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "ROL_MENU")
@IdClass(RolMenuId.class)
public class RolMenu {

    @Id
    @Column(name = "IDMENU", nullable = false)
    private Integer idMenu;

    @Id
    @Column(name = "IDROL", nullable = false)
    private Integer idRol;

    // Getters y Setters

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
}

