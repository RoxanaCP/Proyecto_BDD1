package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Producto;
import com.ventaropa.venta.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

      public List<Producto> listarProductos() {
        return repository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Integer id) {
        return repository.findById(id);
    }


    public Producto guardarProducto(Producto producto) {
        return repository.save(producto);
    }

    public Producto actualizarProducto(Integer id, Producto productoActualizado) {
        return repository.findById(id)
                .map(producto -> {
                    producto.setNombre(productoActualizado.getNombre());
                    return repository.save(producto);
                })
                .orElse(null);
    }

    public boolean eliminarProducto(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
