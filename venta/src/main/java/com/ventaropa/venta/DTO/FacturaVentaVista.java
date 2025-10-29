package com.ventaropa.venta.DTO;

import java.math.BigDecimal;
import java.util.Date;

public interface FacturaVentaVista {
    Integer getIdFacturaVenta();
    String getNombrePago();
    String getTipoVenta();
    String getNombreEmpleado();
    String getNombreSucursal();
    String getNombreCliente();
    Date getFecha();
    BigDecimal getTotal();
}
