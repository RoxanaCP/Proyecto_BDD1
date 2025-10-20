package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Producto;
import com.ventaropa.venta.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public Producto buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
