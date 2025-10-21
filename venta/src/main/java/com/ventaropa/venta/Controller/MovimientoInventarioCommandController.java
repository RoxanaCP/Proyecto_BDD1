// MovimientoInventarioCommandController.java
package com.ventaropa.venta.Controller;

import com.ventaropa.venta.DTO.MovimientoInventarioReq;
import com.ventaropa.venta.DTO.MovimientoInventarioRes;
import com.ventaropa.venta.Service.MovimientoInventarioCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos-inventario")
@CrossOrigin(origins = "*")
public class MovimientoInventarioCommandController {

    private final MovimientoInventarioCommandService commandService;

    public MovimientoInventarioCommandController(MovimientoInventarioCommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping("/crear")
    public ResponseEntity<MovimientoInventarioRes> crear(@RequestBody MovimientoInventarioReq req) {
        MovimientoInventarioRes res = commandService.registrarMovimiento(req);
        return ResponseEntity.ok(res);
    }
}
