package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpcionRepository extends JpaRepository<Opcion, Integer> {
    // lectura simple por FK (sin ignorecase/like para no chocar con CLOB)
    List<Opcion> findByIdMenu(Integer idMenu);
}
