package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
    // No se necesita método adicional, JpaRepository ya tiene findAll()
}
