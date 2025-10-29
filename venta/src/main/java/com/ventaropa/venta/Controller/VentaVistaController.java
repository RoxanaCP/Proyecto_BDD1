package com.ventaropa.venta.Controller;

import com.ventaropa.venta.DTO.VentaVistaDTO;
import com.ventaropa.venta.Service.VentaVistaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas-vista")
@CrossOrigin(origins = "*")
public class VentaVistaController {

    private final VentaVistaService service;

    public VentaVistaController(VentaVistaService service) {
        this.service = service;
    }

    @GetMapping
    public List<VentaVistaDTO> listarVentas() {
        return service.listarVentas(); // Esto devuelve List<VentaVistaDTO>
    }
}

