// src/main/java/com/ventaropa/venta/DTO/MovimientoInventarioRes.java
package com.ventaropa.venta.DTO;

public class MovimientoInventarioRes {
    private Integer idMovimiento;
    private String mensaje;

    public MovimientoInventarioRes(Integer idMovimiento, String mensaje) {
        this.idMovimiento = idMovimiento;
        this.mensaje = mensaje;
    }
    public Integer getIdMovimiento() { return idMovimiento; }
    public String getMensaje() { return mensaje; }
}
