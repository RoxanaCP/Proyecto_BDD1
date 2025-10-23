// src/main/java/com/ventaropa/venta/Repository/PagoRepository.java
package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Integer> {

    // Listar pagos por tipo (efectivo, tarjeta, etc.)
    List<Pago> findByIdTipoPagoOrderByIdPagoAsc(Integer idTipoPago);
}
