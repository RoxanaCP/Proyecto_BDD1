package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Opcion;
import com.ventaropa.venta.Service.OpcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/opciones") @CrossOrigin(origins="*")
public class OpcionController {
    private final OpcionService service;
    public OpcionController(OpcionService service){ this.service = service; }

    @GetMapping public List<Opcion> listar(){ return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Opcion> buscar(@PathVariable Integer id){
        Opcion o = service.buscar(id);
        return (o!=null)? ResponseEntity.ok(o) : ResponseEntity.notFound().build();
    }

    // **clave para la vista**: opciones por menú
    @GetMapping("/por-menu/{idMenu}")
    public List<Opcion> porMenu(@PathVariable Integer idMenu){
        return service.listarPorMenu(idMenu);
    }
}
