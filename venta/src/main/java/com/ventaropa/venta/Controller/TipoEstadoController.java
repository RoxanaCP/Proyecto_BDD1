// src/main/java/com/ventaropa/venta/Controller/TipoEstadoController.java
package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.TipoEstado;
import com.ventaropa.venta.Service.TipoEstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-estado")
@CrossOrigin(origins = "*")
public class TipoEstadoController {

    private final TipoEstadoService service;

    public TipoEstadoController(TipoEstadoService service) {
        this.service = service;
    }

    // Listar todos (o filtrar con ?q=texto)
    @GetMapping
    public List<TipoEstado> listar(@RequestParam(value = "q", required = false) String q) {
        return (q == null) ? service.listar() : service.buscarPorDescripcion(q);
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoEstado> porId(@PathVariable Integer id) {
        TipoEstado te = service.buscar(id);
        return (te != null) ? ResponseEntity.ok(te) : ResponseEntity.notFound().build();
    }
}
