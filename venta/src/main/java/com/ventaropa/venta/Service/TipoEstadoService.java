// src/main/java/com/ventaropa/venta/Service/TipoEstadoService.java
package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.TipoEstado;
import com.ventaropa.venta.Repository.TipoEstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEstadoService {

    private final TipoEstadoRepository repo;

    public TipoEstadoService(TipoEstadoRepository repo) {
        this.repo = repo;
    }

    public List<TipoEstado> listar() {
        return repo.findAll();
    }

    public TipoEstado buscar(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public List<TipoEstado> buscarPorDescripcion(String texto) {
        if (texto == null || texto.isBlank()) return listar();
        return repo.searchByDescripcion(texto);
    }
}
