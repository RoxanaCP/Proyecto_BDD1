package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.MovimientoInventario;
import com.ventaropa.venta.Service.MovimientoInventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos-inventario")
@CrossOrigin(origins = "*")
public class MovimientoInventarioController {

    private final MovimientoInventarioService service;

    public MovimientoInventarioController(MovimientoInventarioService service) {
        this.service = service;
    }

    // Listar todos
    @GetMapping
    public List<MovimientoInventario> listar() {
        return service.listar();
    }

    // Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<MovimientoInventario> buscar(@PathVariable Integer id) {
        MovimientoInventario mov = service.buscar(id);
        return (mov != null) ? ResponseEntity.ok(mov) : ResponseEntity.notFound().build();
    }
}
