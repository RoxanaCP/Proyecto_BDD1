package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Bodega;
import com.ventaropa.venta.Service.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bodegas")
@CrossOrigin(origins = "*")
public class BodegaController {
    @Autowired private BodegaService service;

    // GET /bodegas -> lista todas
    @GetMapping
    public List<Bodega> getAll() { return service.listarTodas(); }
}
