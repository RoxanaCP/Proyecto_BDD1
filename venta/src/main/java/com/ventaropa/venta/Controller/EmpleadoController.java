// src/main/java/com/ventaropa/venta/Controller/EmpleadoController.java
package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Empleado;
import com.ventaropa.venta.Service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    // Listar todos
    @GetMapping
    public List<Empleado> listar() {
        return service.listar();
    }

    // Buscar por ID
    @GetMapping("/{idEmpleado}")
    public ResponseEntity<Empleado> porId(@PathVariable Integer idEmpleado) {
        Empleado e = service.buscar(idEmpleado);
        return (e != null) ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    // Filtrar por sucursal
    @GetMapping("/por-sucursal/{idSucursal}")
    public List<Empleado> porSucursal(@PathVariable Integer idSucursal) {
        return service.porSucursal(idSucursal);
    }

    // Filtrar por turno
    @GetMapping("/por-turno/{idTurno}")
    public List<Empleado> porTurno(@PathVariable Integer idTurno) {
        return service.porTurno(idTurno);
    }

    // Filtrar por persona
    @GetMapping("/por-persona/{idPersona}")
    public List<Empleado> porPersona(@PathVariable Integer idPersona) {
        return service.porPersona(idPersona);
    }
}
