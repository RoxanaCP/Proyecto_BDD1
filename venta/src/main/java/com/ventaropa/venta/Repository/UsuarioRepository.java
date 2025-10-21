package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  @Query(value = """
      SELECT * FROM USUARIO u
       WHERE UPPER(DBMS_LOB.SUBSTR(u.NOMBREUSUARIO, 4000)) = UPPER(:username)
         AND DBMS_LOB.SUBSTR(u.CONTRASENA, 4000) = :shaHex
         AND u.ACTIVO = 1
    """, nativeQuery = true)
  Usuario loginByUsernameAndSha(String username, String shaHex);
}
