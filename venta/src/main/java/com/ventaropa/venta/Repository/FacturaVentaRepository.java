// src/main/java/com/ventaropa/venta/Repository/FacturaVentaRepository.java
package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.FacturaVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface FacturaVentaRepository extends JpaRepository<FacturaVenta, Integer> {

    // Por cliente
    List<FacturaVenta> findByIdCliente(Integer idCliente);

    // Por sucursal
    List<FacturaVenta> findByIdSucursal(Integer idSucursal);

    // Rango de fechas (incluye ambas)
    @Query(value = """
        SELECT * 
          FROM FACTURA_VENTA f
         WHERE TRUNC(f.FECHA) BETWEEN TRUNC(:desde) AND TRUNC(:hasta)
         ORDER BY f.FECHA DESC, f.IDFACTURAVENTA DESC
    """, nativeQuery = true)
    List<FacturaVenta> findByFechaEntre(Date desde, Date hasta);

    // Por día exacto (TRUNC para ignorar hora)
    @Query(value = """
        SELECT * 
          FROM FACTURA_VENTA f
         WHERE TRUNC(f.FECHA) = TRUNC(:dia)
         ORDER BY f.IDFACTURAVENTA DESC
    """, nativeQuery = true)
    List<FacturaVenta> findByFechaDia(Date dia);
}
