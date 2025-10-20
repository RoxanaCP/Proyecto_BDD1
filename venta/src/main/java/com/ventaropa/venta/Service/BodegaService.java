package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Bodega;
import com.ventaropa.venta.Repository.BodegaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BodegaService {
    @Autowired private BodegaRepository repo;
    public List<Bodega> listarTodas(){ return repo.findAll(); }
}
