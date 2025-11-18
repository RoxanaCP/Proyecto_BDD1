package com.ventaropa.venta.Controller;

import com.ventaropa.venta.DTO.FacturaVentaDTO;
import com.ventaropa.venta.Entity.FacturaVenta;
import com.ventaropa.venta.Service.FacturaVentaService;
import com.ventaropa.venta.Service.VentaQueryService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "*")
public class FacturaVentaController {

    private final FacturaVentaService service;
    private final VentaQueryService queryService;

    public FacturaVentaController(FacturaVentaService service, VentaQueryService queryService) {
        this.service = service;
        this.queryService = queryService;
    }

    // Listar todas
    @GetMapping
    public List<FacturaVenta> listar() {
        return service.listar();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<FacturaVenta> porId(@PathVariable Integer id) {
        FacturaVenta f = service.buscar(id);
        return (f != null) ? ResponseEntity.ok(f) : ResponseEntity.notFound().build();
    }

    // Por cliente
    @GetMapping("/por-cliente/{idCliente}")
    public List<FacturaVenta> porCliente(@PathVariable Integer idCliente) {
        return service.porCliente(idCliente);
    }

    // Por sucursal
    @GetMapping("/por-sucursal/{idSucursal}")
    public List<FacturaVenta> porSucursal(@PathVariable Integer idSucursal) {
        return service.porSucursal(idSucursal);
    }

    // Por rango de fechas
    @GetMapping("/por-fecha")
    public List<FacturaVenta> porRango(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hasta) {
        return service.porRango(desde, hasta);
    }

    // Por día
    @GetMapping("/por-dia")
    public List<FacturaVenta> porDia(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {
        return service.porDia(fecha);
    }

    @GetMapping("/listar")
    public List<FacturaVentaDTO> listarFacturas() {
        return service.obtenerFacturasConNombres();
    }


    // =====================================================
    // NUEVO: DETALLE COMPLETO DE FACTURA — SIEMPRE JSON
    // =====================================================
    @GetMapping("/detalle/{id}")
    public ResponseEntity<?> obtenerDetalle(@PathVariable Integer id) {
        try {
            Object resultado = queryService.obtenerFactura(id);

            if (resultado == null) {
                return ResponseEntity
                        .status(404)
                        .body(new RespuestaError("Factura no encontrada"));
            }

            return ResponseEntity.ok(resultado);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .body(new RespuestaError("Error al obtener el detalle: " + e.getMessage()));
        }
    }

    // Clase interna para devolver errores en JSON
    static class RespuestaError {
        public String mensaje;
        public RespuestaError(String mensaje) {
            this.mensaje = mensaje;
        }
    }

}
