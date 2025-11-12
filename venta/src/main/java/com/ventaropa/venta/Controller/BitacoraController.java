package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Bitacora;
import com.ventaropa.venta.Service.BitacoraService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bitacora")
@CrossOrigin(origins = "*")
public class BitacoraController {

    private final BitacoraService service;

    public BitacoraController(BitacoraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Bitacora> listar() {
        return service.listar();
    }
}
