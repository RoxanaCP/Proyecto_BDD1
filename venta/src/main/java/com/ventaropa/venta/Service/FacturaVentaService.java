// src/main/java/com/ventaropa/venta/Service/FacturaVentaService.java
package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.FacturaVenta;
import com.ventaropa.venta.Repository.FacturaVentaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacturaVentaService {

    private final FacturaVentaRepository repo;

    public FacturaVentaService(FacturaVentaRepository repo) {
        this.repo = repo;
    }

    public List<FacturaVenta> listar() {
        return repo.findAll();
    }

    public FacturaVenta buscar(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public List<FacturaVenta> porCliente(Integer idCliente) {
        return repo.findByIdCliente(idCliente);
    }

    public List<FacturaVenta> porSucursal(Integer idSucursal) {
        return repo.findByIdSucursal(idSucursal);
    }

    public List<FacturaVenta> porRango(Date desde, Date hasta) {
        return repo.findByFechaEntre(desde, hasta);
    }

    public List<FacturaVenta> porDia(Date dia) {
        return repo.findByFechaDia(dia);
    }
}
