package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.CentroComercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CentroComercialRepository extends JpaRepository<CentroComercial, Integer> {
    // Quita cualquier findBy...IgnoreCaseContaining / findBy...Containing
}

