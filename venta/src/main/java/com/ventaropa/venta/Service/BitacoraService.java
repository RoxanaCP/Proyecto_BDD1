package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Bitacora;
import com.ventaropa.venta.Repository.BitacoraRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BitacoraService {

    private final BitacoraRepository repository;

    public BitacoraService(BitacoraRepository repository) {
        this.repository = repository;
    }

    public List<Bitacora> listar() {
        return repository.findAll();
    }
}
