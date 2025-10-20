package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Sucursal;
import com.ventaropa.venta.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
@CrossOrigin(origins = "*")
public class SucursalController {

    @Autowired
    private SucursalService service;

    // GET /sucursales -> listar todas
    @GetMapping
    public List<Sucursal> getAll() {
        return service.listarTodas();
    }

    // GET /sucursales/{id} -> buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getById(@PathVariable Integer id) {
        Sucursal s = service.buscarPorId(id);
        return (s != null) ? ResponseEntity.ok(s) : ResponseEntity.notFound().build();
    }
}
