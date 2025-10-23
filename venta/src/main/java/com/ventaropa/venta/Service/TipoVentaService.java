package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.TipoVenta;
import com.ventaropa.venta.Repository.TipoVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoVentaService {
    private final TipoVentaRepository repo;

    public TipoVentaService(TipoVentaRepository repo) {
        this.repo = repo;
    }

    public List<TipoVenta> listar() { return repo.findAll(); }

    public TipoVenta buscar(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
