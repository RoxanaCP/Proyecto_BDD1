// src/main/java/com/ventaropa/venta/Controller/VentaCommandController.java
package com.ventaropa.venta.Controller;

import com.ventaropa.venta.DTO.VentaCrearReq;
import com.ventaropa.venta.DTO.VentaCrearRes;
import com.ventaropa.venta.Service.VentaCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
public class VentaCommandController {

  private final VentaCommandService ventaCommandService;

  public VentaCommandController(VentaCommandService ventaCommandService) {
    this.ventaCommandService = ventaCommandService;
  }

  @PostMapping("/ventas/crear")
  public ResponseEntity<VentaCrearRes> crear(
      @RequestBody VentaCrearReq req,
      @RequestHeader(value = "X-Empleado-Id", required = false) Integer empleadoIdHeader
  ){
    if (empleadoIdHeader == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falta header X-Empleado-Id");
    }
    VentaCrearRes res = ventaCommandService.crear(req, empleadoIdHeader); // <-- SOLO 2 args
    return ResponseEntity.ok(res);
  }
}
