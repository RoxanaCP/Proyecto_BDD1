package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    // Sin métodos extra: findAll() y findById() ya vienen en JpaRepository
}
