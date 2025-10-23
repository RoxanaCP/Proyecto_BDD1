// src/main/java/com/ventaropa/venta/Controller/PersonaController.java
package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Persona;
import com.ventaropa.venta.Service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "*")
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }

    // Listar todas
    @GetMapping
    public List<Persona> listar() {
        return service.listar();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtener(@PathVariable Integer id) {
        Persona p = service.buscarPorId(id);
        return (p != null) ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    // Buscar por nombre (contiene, case-insensitive)
    // Ej: GET /personas/buscar?nombre=maria
    @GetMapping("/buscar")
    public List<Persona> buscar(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }
}
