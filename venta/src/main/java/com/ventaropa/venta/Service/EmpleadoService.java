package com.ventaropa.venta.Service;

import com.ventaropa.venta.DTO.EmpleadoVista;
import com.ventaropa.venta.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EmpleadoService {

  @Autowired
  private EmpleadoRepository empleadoRepository;

  // Devolver directamente la vista con nombrePersona y fechaIngreso
  public List<EmpleadoVista> listarPorSucursalTurnoYFecha(Integer idSucursal, Integer idTurno, Date fecha) {
    return empleadoRepository.findVistaBySucursalTurnoYFecha(idSucursal, idTurno, fecha);
  }
}
