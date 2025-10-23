package com.ventaropa.venta.Service;

import com.ventaropa.venta.DTO.ClienteVista;
import com.ventaropa.venta.Entity.Cliente;
import com.ventaropa.venta.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente buscar(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Optional<ClienteVista> vista(Integer id) {
        return repo.vistaById(id);
    }
}
