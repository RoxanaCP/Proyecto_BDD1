package com.ventaropa.venta.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_seq")
    @SequenceGenerator(name = "empleado_seq", sequenceName = "EMPLEADO_SEQ", allocationSize = 1)
    @Column(name = "IDEMPLEADO")
    private Integer idEmpleado;

    @Column(name = "IDTURNO", nullable = false)
    private Integer idTurno;

    @Column(name = "IDSUCURSAL", nullable = false)
    private Integer idSucursal;

    @Column(name = "IDPERSONA", nullable = false)
    private Integer idPersona;

    @Column(name = "FECHAINGRESO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    // Getters y Setters

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
