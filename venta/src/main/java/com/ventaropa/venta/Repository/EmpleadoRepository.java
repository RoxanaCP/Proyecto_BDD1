package com.ventaropa.venta.Repository;

import com.ventaropa.venta.DTO.EmpleadoVista;
import com.ventaropa.venta.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

  // (opcional) método anterior si lo quieres conservar
  @Query(value = "SELECT * FROM EMPLEADO e " +
                 "WHERE e.IDSUCURSAL = :idSucursal " +
                 "  AND e.IDTURNO = :idTurno " +
                 "  AND TRUNC(e.FECHAINGRESO) = :fecha",
         nativeQuery = true)
  List<Empleado> findBySucursalTurnoYFecha(@Param("idSucursal") Integer idSucursal,
                                           @Param("idTurno") Integer idTurno,
                                           @Param("fecha") Date fecha);

  // >>> NUEVO: proyección con nombre de la persona y fecha de ingreso
  @Query(value = "SELECT " +
                 "  DBMS_LOB.SUBSTR(p.NOMBRE, 4000) AS nombrePersona, " +
                 "  e.FECHAINGRESO AS fechaIngreso " +
                 "FROM EMPLEADO e " +
                 "JOIN PERSONA p ON p.IDPERSONA = e.IDPERSONA " +
                 "WHERE e.IDSUCURSAL = :idSucursal " +
                 "  AND e.IDTURNO = :idTurno " +
                 "  AND TRUNC(e.FECHAINGRESO) = :fecha",
         nativeQuery = true)
  List<EmpleadoVista> findVistaBySucursalTurnoYFecha(@Param("idSucursal") Integer idSucursal,
                                                     @Param("idTurno") Integer idTurno,
                                                     @Param("fecha") Date fecha);
}
