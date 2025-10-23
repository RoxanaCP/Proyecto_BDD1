// src/main/java/com/ventaropa/venta/Service/PagoService.java
package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Pago;
import com.ventaropa.venta.Repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    private final PagoRepository repo;

    public PagoService(PagoRepository repo) {
        this.repo = repo;
    }

    public List<Pago> listar() {
        return repo.findAll();
    }

    public Pago buscar(Integer idPago) {
        return repo.findById(idPago).orElse(null);
    }

    public List<Pago> porTipo(Integer idTipoPago) {
        return repo.findByIdTipoPagoOrderByIdPagoAsc(idTipoPago);
    }
}
