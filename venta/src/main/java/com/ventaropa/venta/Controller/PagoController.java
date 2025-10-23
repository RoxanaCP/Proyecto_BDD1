// src/main/java/com/ventaropa/venta/Controller/PagoController.java
package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Pago;
import com.ventaropa.venta.Service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    // Listar todos los pagos (útil para pruebas/consultas)
    @GetMapping
    public List<Pago> listar() {
        return service.listar();
    }

    // Obtener un pago por ID
    @GetMapping("/{idPago}")
    public ResponseEntity<Pago> porId(@PathVariable Integer idPago) {
        Pago p = service.buscar(idPago);
        return (p != null) ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    // Listar pagos por tipo (efectivo, tarjeta, etc.)
    @GetMapping("/por-tipo/{idTipoPago}")
    public List<Pago> porTipo(@PathVariable Integer idTipoPago) {
        return service.porTipo(idTipoPago);
    }
}
