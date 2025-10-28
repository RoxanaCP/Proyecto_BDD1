package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Turno;
import com.ventaropa.venta.Service.TurnoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin(origins = "*") // permite llamadas desde cualquier origen, útil para el front
public class TurnoController {

    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public List<Turno> listarTurnos() {
        return turnoService.obtenerTodosLosTurnos();
    }
}
