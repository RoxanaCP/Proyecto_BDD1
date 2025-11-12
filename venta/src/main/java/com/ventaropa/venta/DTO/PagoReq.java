package com.ventaropa.venta.DTO;

public class PagoReq {
    private Integer idTipoPago;
    private Double monto;

    public Integer getIdTipoPago() { return idTipoPago; }
    public void setIdTipoPago(Integer idTipoPago) { this.idTipoPago = idTipoPago; }

    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
}
