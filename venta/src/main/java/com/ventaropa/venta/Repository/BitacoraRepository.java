package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraRepository extends JpaRepository<Bitacora, Integer> {
}
