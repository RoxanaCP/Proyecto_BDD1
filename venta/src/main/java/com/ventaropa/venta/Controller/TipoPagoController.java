package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.TipoPago;
import com.ventaropa.venta.Service.TipoPagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-pago")
@CrossOrigin(origins = "*")
public class TipoPagoController {

    private final TipoPagoService service;

    public TipoPagoController(TipoPagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoPago> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPago> buscar(@PathVariable Integer id) {
        TipoPago tp = service.buscar(id);
        return (tp != null) ? ResponseEntity.ok(tp) : ResponseEntity.notFound().build();
    }
}
