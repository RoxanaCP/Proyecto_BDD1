// src/main/java/com/ventaropa/venta/Service/EmpleadoService.java
package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Empleado;
import com.ventaropa.venta.Repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repo;

    public EmpleadoService(EmpleadoRepository repo) {
        this.repo = repo;
    }

    public List<Empleado> listar() {
        return repo.findAll();
    }

    public Empleado buscar(Integer idEmpleado) {
        return repo.findById(idEmpleado).orElse(null);
    }

    public List<Empleado> porSucursal(Integer idSucursal) {
        return repo.findByIdSucursalOrderByIdEmpleadoAsc(idSucursal);
    }

    public List<Empleado> porTurno(Integer idTurno) {
        return repo.findByIdTurnoOrderByIdEmpleadoAsc(idTurno);
    }

    public List<Empleado> porPersona(Integer idPersona) {
        return repo.findByIdPersonaOrderByIdEmpleadoAsc(idPersona);
    }
}
