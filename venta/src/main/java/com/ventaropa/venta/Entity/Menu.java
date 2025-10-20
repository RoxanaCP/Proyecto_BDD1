package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MENU")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
    @SequenceGenerator(name = "menu_seq", sequenceName = "MENU_SEQ", allocationSize = 1)
    @Column(name = "IDMENU")
    private Integer idMenu;

    @Column(name = "IDMODULO", nullable = false)
    private Integer idModulo;

    @Lob
    @Column(name = "NOMBREMENU", nullable = false)
    private String nombreMenu;

    // Getters y Setters

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }
}

