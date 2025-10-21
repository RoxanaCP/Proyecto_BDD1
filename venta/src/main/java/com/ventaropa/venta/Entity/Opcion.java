package com.ventaropa.venta.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OPCION")
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opcion_seq")
    @SequenceGenerator(name = "opcion_seq", sequenceName = "OPCION_SEQ", allocationSize = 1)
    @Column(name = "IDOPCION")
    private Integer idOpcion;

    @Column(name = "IDMENU", nullable = false)
    private Integer idMenu;

    @Lob
    @Column(name = "NOMBREOPCION", nullable = false)
    private String nombreOpcion;

    // NUEVO: mapea la columna RUTA (VARCHAR2)
    @Column(name = "RUTA")
    private String ruta;

    // Getters y Setters
    public Integer getIdOpcion() { return idOpcion; }
    public void setIdOpcion(Integer idOpcion) { this.idOpcion = idOpcion; }

    public Integer getIdMenu() { return idMenu; }
    public void setIdMenu(Integer idMenu) { this.idMenu = idMenu; }

    public String getNombreOpcion() { return nombreOpcion; }
    public void setNombreOpcion(String nombreOpcion) { this.nombreOpcion = nombreOpcion; }

    public String getRuta() { return ruta; }
    public void setRuta(String ruta) { this.ruta = ruta; }
}
