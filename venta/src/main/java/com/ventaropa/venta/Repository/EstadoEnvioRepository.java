// src/main/java/com/ventaropa/venta/Repository/EstadoEnvioRepository.java
package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.EstadoEnvio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoEnvioRepository extends JpaRepository<EstadoEnvio, Integer> {

    // Todos los estados de una factura (del más antiguo al más reciente)
    List<EstadoEnvio> findByIdFacturaVentaOrderByIdEstadoEnvioAsc(Integer idFacturaVenta);

    // Último estado registrado para una factura
    Optional<EstadoEnvio> findTopByIdFacturaVentaOrderByIdEstadoEnvioDesc(Integer idFacturaVenta);

    // Buscar por tipo (Pendiente / Enviado / Entregado, etc.)
    List<EstadoEnvio> findByIdTipoEstadoOrderByIdEstadoEnvioAsc(Integer idTipoEstado);
}
