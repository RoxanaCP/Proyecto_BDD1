package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Modulo;
import com.ventaropa.venta.Repository.ModuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuloService {
    private final ModuloRepository repo;
    public ModuloService(ModuloRepository repo){ this.repo = repo; }

    public List<Modulo> listar(){ return repo.findAll(); }
    public Modulo buscar(Integer id){ return repo.findById(id).orElse(null); }
}
