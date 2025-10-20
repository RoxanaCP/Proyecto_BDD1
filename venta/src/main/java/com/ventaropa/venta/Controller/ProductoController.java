package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Producto;
import com.ventaropa.venta.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService service;

    // GET /productos -> listar todos
    @GetMapping
    public List<Producto> getAll() {
        return service.listarTodos();
    }

    // GET /productos/{id} -> buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Integer id) {
        Producto p = service.buscarPorId(id);
        return (p != null) ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }
}
