// src/main/java/com/ventaropa/venta/Service/InventarioService.java
package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Inventario;
import com.ventaropa.venta.Repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    private final InventarioRepository repo;

    public InventarioService(InventarioRepository repo) {
        this.repo = repo;
    }

    public List<Inventario> listar() {
        return repo.findAll();
    }

    public Inventario buscar(Integer idInventario) {
        return repo.findById(idInventario).orElse(null);
    }

    public List<Inventario> porBodega(Integer idBodega) {
        return repo.findByIdBodegaOrderByIdInventarioAsc(idBodega);
    }

    public List<Inventario> porProducto(Integer idProducto) {
        return repo.findByIdProductoOrderByIdInventarioAsc(idProducto);
    }

    public Inventario porBodegaYProducto(Integer idBodega, Integer idProducto) {
        return repo.findFirstByIdBodegaAndIdProducto(idBodega, idProducto);
    }

    public List<InventarioRepository.ResumenProducto> resumenPorProducto() {
        return repo.resumenPorProducto();
    }
}
