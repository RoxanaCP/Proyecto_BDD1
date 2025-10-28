package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Turno;
import com.ventaropa.venta.Repository.TurnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public List<Turno> obtenerTodosLosTurnos() {
        return turnoRepository.findAll();
    }
}
