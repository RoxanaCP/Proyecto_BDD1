// src/main/java/com/ventaropa/venta/Service/EstadoEnvioService.java
package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.EstadoEnvio;
import com.ventaropa.venta.Repository.EstadoEnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoEnvioService {

    private final EstadoEnvioRepository repo;

    public EstadoEnvioService(EstadoEnvioRepository repo) {
        this.repo = repo;
    }

    public List<EstadoEnvio> listar() {
        return repo.findAll();
    }

    public EstadoEnvio buscar(Integer idEstadoEnvio) {
        return repo.findById(idEstadoEnvio).orElse(null);
    }

    public List<EstadoEnvio> porFactura(Integer idFacturaVenta) {
        return repo.findByIdFacturaVentaOrderByIdEstadoEnvioAsc(idFacturaVenta);
    }

    public EstadoEnvio ultimoDeFactura(Integer idFacturaVenta) {
        return repo.findTopByIdFacturaVentaOrderByIdEstadoEnvioDesc(idFacturaVenta).orElse(null);
    }

    public List<EstadoEnvio> porTipoEstado(Integer idTipoEstado) {
        return repo.findByIdTipoEstadoOrderByIdEstadoEnvioAsc(idTipoEstado);
    }
}
