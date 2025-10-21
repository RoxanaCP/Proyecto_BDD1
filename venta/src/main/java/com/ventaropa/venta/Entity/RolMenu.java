package com.ventaropa.venta.Entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ROL_MENU")
@IdClass(RolMenuId.class) // tu clase compuesta (IDMENU, IDROL)
public class RolMenu implements Serializable {

    @Id
    @Column(name = "IDMENU", nullable = false)
    private Integer idMenu;

    @Id
    @Column(name = "IDROL", nullable = false)
    private Integer idRol;

    // NUEVOS CAMPOS
    @Column(name = "ALTA", nullable = false)
    private Short alta;    // 0/1

    @Column(name = "BAJA", nullable = false)
    private Short baja;    // 0/1

    @Column(name = "CAMBIO", nullable = false)
    private Short cambio;  // 0/1

    // Getters & Setters
    public Integer getIdMenu() { return idMenu; }
    public void setIdMenu(Integer idMenu) { this.idMenu = idMenu; }

    public Integer getIdRol() { return idRol; }
    public void setIdRol(Integer idRol) { this.idRol = idRol; }

    public Short getAlta() { return alta; }
    public void setAlta(Short alta) { this.alta = alta; }

    public Short getBaja() { return baja; }
    public void setBaja(Short baja) { this.baja = baja; }

    public Short getCambio() { return cambio; }
    public void setCambio(Short cambio) { this.cambio = cambio; }
}
