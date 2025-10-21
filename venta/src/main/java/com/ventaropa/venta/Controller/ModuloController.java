package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Modulo;
import com.ventaropa.venta.Service.ModuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/modulos") @CrossOrigin(origins="*")
public class ModuloController {
    private final ModuloService service;
    public ModuloController(ModuloService service){ this.service = service; }

    @GetMapping public List<Modulo> listar(){ return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Modulo> buscar(@PathVariable Integer id){
        Modulo m = service.buscar(id);
        return (m!=null)? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }
}
