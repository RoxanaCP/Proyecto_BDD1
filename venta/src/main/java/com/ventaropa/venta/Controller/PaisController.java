package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Pais;
import com.ventaropa.venta.Service.PaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/pais")
@CrossOrigin(origins = "*")
public class PaisController {
    private final PaisService paisService;
    public PaisController(PaisService paisService){ this.paisService = paisService; }

    // GET /pais  -> lista todos
    @GetMapping
    public List<Pais> obtenerPaises() {
        return paisService.obtenerPaises();
    }

    // GET /pais/{id} -> buscar por id
    @GetMapping("/{idPais}")
    public ResponseEntity<Pais> buscarPais(@PathVariable Integer idPais) {
        Pais pais = paisService.buscarPais(idPais);
        return (pais != null) ? ResponseEntity.ok(pais) : ResponseEntity.notFound().build();
    }
}
