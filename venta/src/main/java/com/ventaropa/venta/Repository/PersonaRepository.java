// src/main/java/com/ventaropa/venta/Repository/PersonaRepository.java
package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    // Búsqueda por nombre (contiene, case-insensitive) compatible con CLOB
    @Query(value = """
        SELECT *
          FROM PERSONA p
         WHERE UPPER(DBMS_LOB.SUBSTR(p.NOMBRE, 4000)) LIKE UPPER('%' || :nombre || '%')
         ORDER BY p.IDPERSONA
        """, nativeQuery = true)
    List<Persona> buscarPorNombre(String nombre);
}
