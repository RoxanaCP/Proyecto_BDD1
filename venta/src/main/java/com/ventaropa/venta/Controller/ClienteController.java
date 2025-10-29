package com.ventaropa.venta.Controller;

import com.ventaropa.venta.DTO.ClienteDTO;
import com.ventaropa.venta.DTO.ClienteVista;
import com.ventaropa.venta.Entity.Cliente;
import com.ventaropa.venta.Service.ClienteService;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> obtener(@PathVariable Integer id) {
        String nombre = service.buscar(id);
        return (nombre != null) ? ResponseEntity.ok(nombre) : ResponseEntity.notFound().build();
    }

    // Vista enriquecida (CLIENTE + PERSONA)
    @GetMapping("/{id}/vista")
    public ResponseEntity<ClienteVista> vista(@PathVariable Integer id) {
        return service.vista(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


     @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody ClienteDTO dto) {
        try {
            Cliente cliente = service.agregarCliente(dto);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("{\"message\":\"No se pudo completar la operación.\"}");
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Integer id){
        try {
            service.eliminarClienteYPersona(id);
            return ResponseEntity.ok().body("Cliente y persona eliminados correctamente");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo eliminar el cliente: " + e.getMessage());
        }
    }
}
