package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Métodos básicos heredados: findAll(), findById(id)
}
