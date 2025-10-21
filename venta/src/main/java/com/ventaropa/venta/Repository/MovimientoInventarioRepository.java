package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.MovimientoInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventario, Integer> {
    // sin métodos extra: findAll() y findById(...) ya vienen en JpaRepository
}
