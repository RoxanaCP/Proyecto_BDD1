// src/main/java/com/ventaropa/venta/Controller/FacturaVentaController.java
package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.FacturaVenta;
import com.ventaropa.venta.Service.FacturaVentaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "*")
public class FacturaVentaController {

    private final FacturaVentaService service;

    public FacturaVentaController(FacturaVentaService service) {
        this.service = service;
    }

    // Listar todas
    @GetMapping
    public List<FacturaVenta> listar() {
        return service.listar();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<FacturaVenta> porId(@PathVariable Integer id) {
        FacturaVenta f = service.buscar(id);
        return (f != null) ? ResponseEntity.ok(f) : ResponseEntity.notFound().build();
    }

    // Por cliente
    @GetMapping("/por-cliente/{idCliente}")
    public List<FacturaVenta> porCliente(@PathVariable Integer idCliente) {
        return service.porCliente(idCliente);
    }

    // Por sucursal
    @GetMapping("/por-sucursal/{idSucursal}")
    public List<FacturaVenta> porSucursal(@PathVariable Integer idSucursal) {
        return service.porSucursal(idSucursal);
    }

    // Por rango de fechas (YYYY-MM-DD)
    @GetMapping("/por-fecha")
    public List<FacturaVenta> porRango(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hasta) {
        return service.porRango(desde, hasta);
    }

    // Por día exacto (YYYY-MM-DD)
    @GetMapping("/por-dia")
    public List<FacturaVenta> porDia(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {
        return service.porDia(fecha);
    }
}
