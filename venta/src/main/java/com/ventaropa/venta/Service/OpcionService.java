package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Opcion;
import com.ventaropa.venta.Repository.OpcionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcionService {
    private final OpcionRepository repo;
    public OpcionService(OpcionRepository repo){ this.repo = repo; }

    public List<Opcion> listar(){ return repo.findAll(); }
    public Opcion buscar(Integer id){ return repo.findById(id).orElse(null); }

    public List<Opcion> listarPorMenu(Integer idMenu){
        return repo.findByIdMenu(idMenu);
    }
}
