package com.ventaropa.venta.DTO;

public interface OpcionDto {
    Integer getIdOpcion();
    Integer getIdMenu();
    String getNombreOpcion();
    String getRutaHtml();   // <- nueva propiedad para la ruta/URL
}
