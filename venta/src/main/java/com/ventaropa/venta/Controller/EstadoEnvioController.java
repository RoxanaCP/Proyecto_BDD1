// src/main/java/com/ventaropa/venta/Controller/EstadoEnvioController.java
package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.EstadoEnvio;
import com.ventaropa.venta.Service.EstadoEnvioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado-envio")
@CrossOrigin(origins = "*")
public class EstadoEnvioController {

    private final EstadoEnvioService service;

    public EstadoEnvioController(EstadoEnvioService service) {
        this.service = service;
    }

    // Listar todos
    @GetMapping
    public List<EstadoEnvio> listar() {
        return service.listar();
    }

    // Buscar por ID
    @GetMapping("/{idEstadoEnvio}")
    public ResponseEntity<EstadoEnvio> porId(@PathVariable Integer idEstadoEnvio) {
        EstadoEnvio e = service.buscar(idEstadoEnvio);
        return (e != null) ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    // Todos los estados de una factura
    @GetMapping("/por-factura/{idFacturaVenta}")
    public List<EstadoEnvio> porFactura(@PathVariable Integer idFacturaVenta) {
        return service.porFactura(idFacturaVenta);
    }

    // Último estado (más reciente) de una factura
    @GetMapping("/ultimo-por-factura/{idFacturaVenta}")
    public ResponseEntity<EstadoEnvio> ultimoDeFactura(@PathVariable Integer idFacturaVenta) {
        EstadoEnvio e = service.ultimoDeFactura(idFacturaVenta);
        return (e != null) ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    // Filtrar por tipo de estado (Pendiente/Enviado/Entregado)
    @GetMapping("/por-tipo/{idTipoEstado}")
    public List<EstadoEnvio> porTipoEstado(@PathVariable Integer idTipoEstado) {
        return service.porTipoEstado(idTipoEstado);
    }
}
