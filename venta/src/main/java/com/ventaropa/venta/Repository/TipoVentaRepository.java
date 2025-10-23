package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.TipoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoVentaRepository extends JpaRepository<TipoVenta, Integer> {
}
