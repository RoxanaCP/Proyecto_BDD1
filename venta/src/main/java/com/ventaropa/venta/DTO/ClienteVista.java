package com.ventaropa.venta.DTO;

import java.util.Date;

public interface ClienteVista {
    Integer getIdCliente();
    Integer getIdPersona();
    String  getNit();
    String  getEmail();
    Date    getFechaCreacion();

    // Campos provenientes de PERSONA
    String  getNombrePersona();
    Long    getTelefono();
}
