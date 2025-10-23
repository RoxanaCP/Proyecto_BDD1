// src/main/java/com/ventaropa/venta/Service/PersonaService.java
package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Persona;
import com.ventaropa.venta.Repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository repo;

    public PersonaService(PersonaRepository repo) {
        this.repo = repo;
    }

    public List<Persona> listar() {
        return repo.findAll();
    }

    public Persona buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public List<Persona> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) return List.of();
        return repo.buscarPorNombre(nombre);
    }
}
