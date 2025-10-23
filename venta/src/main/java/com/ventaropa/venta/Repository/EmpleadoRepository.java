// src/main/java/com/ventaropa/venta/Repository/EmpleadoRepository.java
package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    List<Empleado> findByIdSucursalOrderByIdEmpleadoAsc(Integer idSucursal);
    List<Empleado> findByIdTurnoOrderByIdEmpleadoAsc(Integer idTurno);
    List<Empleado> findByIdPersonaOrderByIdEmpleadoAsc(Integer idPersona);
}
