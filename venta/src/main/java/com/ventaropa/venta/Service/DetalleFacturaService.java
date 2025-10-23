// src/main/java/com/ventaropa/venta/Service/DetalleFacturaService.java
package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.DetalleFactura;
import com.ventaropa.venta.Repository.DetalleFacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaService {

    private final DetalleFacturaRepository repo;

    public DetalleFacturaService(DetalleFacturaRepository repo) {
        this.repo = repo;
    }

    public List<DetalleFactura> listar() {
        return repo.findAll();
    }

    public DetalleFactura buscar(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public List<DetalleFactura> porFactura(Integer idFacturaVenta) {
        return repo.findByIdFacturaVentaOrderByIdDetFactAsc(idFacturaVenta);
    }

    public List<DetalleFactura> porProducto(Integer idProducto) {
        return repo.findByIdProducto(idProducto);
    }
}
