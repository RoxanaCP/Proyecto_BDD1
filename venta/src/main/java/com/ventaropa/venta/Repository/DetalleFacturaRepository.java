// src/main/java/com/ventaropa/venta/Repository/DetalleFacturaRepository.java
package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {

    // Todos los renglones de una factura (ordenados por ID del detalle)
    List<DetalleFactura> findByIdFacturaVentaOrderByIdDetFactAsc(Integer idFacturaVenta);

    // (Opcional) buscar por producto
    List<DetalleFactura> findByIdProducto(Integer idProducto);
}
