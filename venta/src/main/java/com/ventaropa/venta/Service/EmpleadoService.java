package com.ventaropa.venta.Service;

import com.ventaropa.venta.DTO.EmpleadoVista;
import com.ventaropa.venta.Entity.Empleado;
import com.ventaropa.venta.Entity.Persona;
import com.ventaropa.venta.Entity.TipoPago;
import com.ventaropa.venta.Repository.EmpleadoRepository;
import com.ventaropa.venta.Repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EmpleadoService {

  @Autowired
  private EmpleadoRepository empleadoRepository;

  @Autowired
  private PersonaRepository personaRepository;

  // Devolver directamente la vista con nombrePersona y fechaIngreso
  public List<EmpleadoVista> listarPorSucursalTurnoYFecha(Integer idSucursal, Integer idTurno, Date fecha) {
    return empleadoRepository.findVistaBySucursalTurnoYFecha(idSucursal, idTurno, fecha);
  }

   public String buscar(Integer id) {
    Empleado empleTemp = empleadoRepository.findById(id).orElse(null);
    if (empleTemp == null) return null; // por si no existe

    Persona perTemp = personaRepository.findById(empleTemp.getIdPersona()).orElse(null);
    if (perTemp == null) return null;

    return perTemp.getNombre();
  }

}
