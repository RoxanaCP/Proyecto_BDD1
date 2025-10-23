package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Cliente;
import com.ventaropa.venta.DTO.ClienteVista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Vista por ID uniendo PERSONA (NOMBRE es CLOB)
    @Query(value = """
        SELECT 
            c.IDCLIENTE        AS idCliente,
            c.IDPERSONA        AS idPersona,
            c.NIT              AS nit,
            c.EMAIL            AS email,
            c.FECHACREACION    AS fechaCreacion,
            DBMS_LOB.SUBSTR(p.NOMBRE, 4000) AS nombrePersona,
            p.TELEFONO         AS telefono
        FROM CLIENTE c
        JOIN PERSONA p ON p.IDPERSONA = c.IDPERSONA
        WHERE c.IDCLIENTE = :id
        """, nativeQuery = true)
    Optional<ClienteVista> vistaById(Integer id);
}
