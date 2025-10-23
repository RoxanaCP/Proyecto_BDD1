package com.ventaropa.venta.Controller;

import com.ventaropa.venta.DTO.ClienteVista;
import com.ventaropa.venta.Entity.Cliente;
import com.ventaropa.venta.Service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // Listado básico (solo columnas reales de CLIENTE)
    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    // Buscar entidad simple
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable Integer id) {
        Cliente c = service.buscar(id);
        return (c != null) ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }

    // Vista enriquecida (CLIENTE + PERSONA)
    @GetMapping("/{id}/vista")
    public ResponseEntity<ClienteVista> vista(@PathVariable Integer id) {
        return service.vista(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
