// src/main/java/com/ventaropa/venta/Controller/DetalleFacturaController.java
package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.DetalleFactura;
import com.ventaropa.venta.Service.DetalleFacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles-factura")
@CrossOrigin(origins = "*")
public class DetalleFacturaController {

    private final DetalleFacturaService service;

    public DetalleFacturaController(DetalleFacturaService service) {
        this.service = service;
    }

    // Listar todos los detalles (útil para pruebas)
    @GetMapping
    public List<DetalleFactura> listar() {
        return service.listar();
    }

    // Obtener un detalle por su ID
    @GetMapping("/{id}")
    public ResponseEntity<DetalleFactura> porId(@PathVariable Integer id) {
        DetalleFactura d = service.buscar(id);
        return (d != null) ? ResponseEntity.ok(d) : ResponseEntity.notFound().build();
    }

    // Obtener todos los renglones de una factura
    @GetMapping("/por-factura/{idFacturaVenta}")
    public List<DetalleFactura> porFactura(@PathVariable Integer idFacturaVenta) {
        return service.porFactura(idFacturaVenta);
    }

    // (Opcional) Buscar renglones por producto
    @GetMapping("/por-producto/{idProducto}")
    public List<DetalleFactura> porProducto(@PathVariable Integer idProducto) {
        return service.porProducto(idProducto);
    }
}
