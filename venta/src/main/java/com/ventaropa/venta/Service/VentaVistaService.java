package com.ventaropa.venta.Service;

import com.ventaropa.venta.DTO.VentaVistaDTO;
import com.ventaropa.venta.Repository.VentaVistaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaVistaService {

    private final VentaVistaRepository repository;

    public VentaVistaService(VentaVistaRepository repository) {
        this.repository = repository;
    }

    public List<VentaVistaDTO> listarVentas() {
        return repository.listarVentas();
    }
}

