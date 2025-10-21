package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Rol;
import com.ventaropa.venta.Service.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*")
public class RolController {

    private final RolService service;

    public RolController(RolService service) { this.service = service; }

    // GET /roles  -> lista todos (opcional, útil para probar rápidamente)
    @GetMapping
    public List<Rol> listar() {
        return service.listar();
    }

    // GET /roles/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Rol> buscar(@PathVariable Integer id) {
        Rol r = service.buscar(id);
        return (r != null) ? ResponseEntity.ok(r) : ResponseEntity.notFound().build();
    }

    // GET /roles/por-usuario/{idUsuario}
    @GetMapping("/por-usuario/{idUsuario}")
    public List<Rol> porUsuario(@PathVariable Integer idUsuario) {
        return service.rolesPorUsuario(idUsuario);
    }

    // Alternativa: GET /roles/por-usuario?idUsuario=1
    @GetMapping(value = "/por-usuario", params = "idUsuario")
    public List<Rol> porUsuarioQuery(@RequestParam Integer idUsuario) {
        return service.rolesPorUsuario(idUsuario);
    }
}
