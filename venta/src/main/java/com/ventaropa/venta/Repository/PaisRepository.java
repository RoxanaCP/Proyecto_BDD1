package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
    // Quita findByNombreIgnoreCaseContaining; si lo necesitas luego, ver Opción B
}

