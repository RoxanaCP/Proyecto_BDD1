package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Sucursal;
import com.ventaropa.venta.Repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository repository;

    public Sucursal buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Sucursal> listarTodas() {
        return repository.findAll();
    }
}
