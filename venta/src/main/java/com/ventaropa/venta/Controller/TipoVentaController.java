package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.TipoVenta;
import com.ventaropa.venta.Service.TipoVentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-venta")   // <- OJO con este path
@CrossOrigin(origins = "*")
public class TipoVentaController {

    private final TipoVentaService service;

    public TipoVentaController(TipoVentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoVenta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoVenta> buscar(@PathVariable Integer id) {
        TipoVenta tv = service.buscar(id);
        return (tv != null) ? ResponseEntity.ok(tv) : ResponseEntity.notFound().build();
    }
}
