package com.ventaropa.venta.DTO;

public class VentaCrearRes {
  private Integer idFactura;
  private String mensaje;

  public VentaCrearRes() {}

  public VentaCrearRes(Integer idFactura, String mensaje) {
    this.idFactura = idFactura;
    this.mensaje = mensaje;
  }

  public Integer getIdFactura() { return idFactura; }
  public void setIdFactura(Integer idFactura) { this.idFactura = idFactura; }

  public String getMensaje() { return mensaje; }
  public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
