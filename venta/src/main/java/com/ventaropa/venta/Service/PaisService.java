package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Pais;
import com.ventaropa.venta.Repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    // Obtener por ID (null si no existe, como tu ejemplo guía)
    public Pais buscarPais(Integer idPais) {
        return paisRepository.findById(idPais).orElse(null);
    }

  

    // Listar todos
    public List<Pais> obtenerPaises() {
        return paisRepository.findAll();
    }

}
