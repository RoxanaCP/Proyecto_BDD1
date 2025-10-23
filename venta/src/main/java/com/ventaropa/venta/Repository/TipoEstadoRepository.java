// src/main/java/com/ventaropa/venta/Repository/TipoEstadoRepository.java
package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.TipoEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoEstadoRepository extends JpaRepository<TipoEstado, Integer> {

    // Búsqueda opcional por descripción (case-insensitive) sobre CLOB
    @Query(value = """
        SELECT * FROM TIPO_ESTADO te
         WHERE INSTR(UPPER(DBMS_LOB.SUBSTR(te.DESCRIPCION, 4000)), UPPER(:texto)) > 0
         ORDER BY te.IDTIPOESTADO
    """, nativeQuery = true)
    List<TipoEstado> searchByDescripcion(String texto);
}
