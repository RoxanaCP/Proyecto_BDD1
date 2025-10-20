package com.ventaropa.venta.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "SUCURSAL")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sucursal_seq")
    @SequenceGenerator(name = "sucursal_seq", sequenceName = "SUCURSAL_SEQ", allocationSize = 1)
    @Column(name = "IDSUCURSAL")
    private Integer idSucursal;

    @Column(name = "IDPAIS", nullable = false)
    private Integer idPais;

    @Column(name = "IDCENTROCOMERCIAL", nullable = false)
    private Integer idCentroComercial;

    @Lob
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    // Getters y Setters

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public Integer getIdCentroComercial() {
        return idCentroComercial;
    }

    public void setIdCentroComercial(Integer idCentroComercial) {
        this.idCentroComercial = idCentroComercial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
