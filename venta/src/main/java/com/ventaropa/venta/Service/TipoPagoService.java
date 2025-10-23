package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.TipoPago;
import com.ventaropa.venta.Repository.TipoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagoService {
    private final TipoPagoRepository repo;

    public TipoPagoService(TipoPagoRepository repo) {
        this.repo = repo;
    }

    public List<TipoPago> listar() { return repo.findAll(); }

    public TipoPago buscar(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
