// src/main/java/com/ventaropa/venta/Controller/InventarioController.java
package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Inventario;
import com.ventaropa.venta.Repository.InventarioRepository;
import com.ventaropa.venta.Service.InventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
@CrossOrigin(origins = "*")
public class InventarioController {

    private final InventarioService service;

    public InventarioController(InventarioService service) {
        this.service = service;
    }

    // Listar todo el inventario
    @GetMapping
    public List<Inventario> listar() {
        return service.listar();
    }

    // Buscar por ID de inventario
    @GetMapping("/{idInventario}")
    public ResponseEntity<Inventario> porId(@PathVariable Integer idInventario) {
        Inventario inv = service.buscar(idInventario);
        return (inv != null) ? ResponseEntity.ok(inv) : ResponseEntity.notFound().build();
    }

    // Filtrar por bodega
    @GetMapping("/por-bodega/{idBodega}")
    public List<Inventario> porBodega(@PathVariable Integer idBodega) {
        return service.porBodega(idBodega);
    }

    // Filtrar por producto
    @GetMapping("/por-producto/{idProducto}")
    public List<Inventario> porProducto(@PathVariable Integer idProducto) {
        return service.porProducto(idProducto);
    }

    // Obtener una fila específica por bodega y producto
    @GetMapping("/por-bodega-producto")
    public ResponseEntity<Inventario> porBodegaYProducto(
            @RequestParam("bodega") Integer idBodega,
            @RequestParam("producto") Integer idProducto) {
        Inventario inv = service.porBodegaYProducto(idBodega, idProducto);
        return (inv != null) ? ResponseEntity.ok(inv) : ResponseEntity.notFound().build();
    }

    // Resumen total por producto (sumando todas las bodegas)
    @GetMapping("/resumen-por-producto")
    public List<InventarioRepository.ResumenProducto> resumenPorProducto() {
        return service.resumenPorProducto();
    }
}
