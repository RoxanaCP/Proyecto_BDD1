package com.ventaropa.venta.Controller;

import com.ventaropa.venta.DTO.EmpleadoVista;
import com.ventaropa.venta.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

  @Autowired
  private EmpleadoService empleadoService;

  @GetMapping("/sucursal/{idSucursal}/turno/{idTurno}/fecha/{fecha}")
  public List<EmpleadoVista> listarPorSucursalTurnoYFecha(
      @PathVariable Integer idSucursal,
      @PathVariable Integer idTurno,
      @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {

    java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
    return empleadoService.listarPorSucursalTurnoYFecha(idSucursal, idTurno, sqlDate);
  }
}
