package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.MovimientoInventario;
import com.ventaropa.venta.Repository.MovimientoInventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoInventarioService {

    private final MovimientoInventarioRepository repo;

    public MovimientoInventarioService(MovimientoInventarioRepository repo) {
        this.repo = repo;
    }

    public List<MovimientoInventario> listar() {
        return repo.findAll();
    }

    public MovimientoInventario buscar(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
