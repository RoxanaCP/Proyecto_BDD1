package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.CentroComercial;
import com.ventaropa.venta.Service.CentroComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centros-comerciales")
@CrossOrigin(origins = "*")
public class CentroComercialController {

    @Autowired
    private CentroComercialService service;

    // GET /centros-comerciales/{id} → buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<CentroComercial> getById(@PathVariable Integer id) {
        CentroComercial cc = service.buscarPorId(id);
        return (cc != null) ? ResponseEntity.ok(cc) : ResponseEntity.notFound().build();
    }

    // GET /centros-comerciales → listar todos
    @GetMapping
    public List<CentroComercial> getAll() {
        return service.listarTodos();
    }

}
