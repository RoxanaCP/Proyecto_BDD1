package com.ventaropa.venta.Controller;

import com.ventaropa.venta.DTO.FacturaDetalleRes;
import com.ventaropa.venta.Service.VentaQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
public class VentaQueryController {

    private final VentaQueryService ventaQueryService;

    public VentaQueryController(VentaQueryService ventaQueryService) {
        this.ventaQueryService = ventaQueryService;
    }

    @GetMapping("/{idFactura}")
    public ResponseEntity<FacturaDetalleRes> obtenerFactura(
            @PathVariable Integer idFactura
    ) {
        FacturaDetalleRes res = ventaQueryService.obtenerFactura(idFactura);
        return ResponseEntity.ok(res);
    }
}
