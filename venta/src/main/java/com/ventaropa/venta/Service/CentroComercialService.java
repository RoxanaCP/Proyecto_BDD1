package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.CentroComercial;
import com.ventaropa.venta.Repository.CentroComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroComercialService {

    @Autowired
    private CentroComercialRepository centroComercialRepository;

    public CentroComercial buscarPorId(Integer id) {
        return centroComercialRepository.findById(id).orElse(null);
    }

    public List<CentroComercial> listarTodos() {
        return centroComercialRepository.findAll();
    }
}
