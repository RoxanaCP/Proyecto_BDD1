package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Buscar usuario ACTIVO por username (CLOB → DBMS_LOB.SUBSTR)
    @Query(value = """
        SELECT * FROM USUARIO u
         WHERE UPPER(DBMS_LOB.SUBSTR(u.NOMBREUSUARIO, 4000)) = UPPER(:username)
           AND u.ACTIVO = 1
      """, nativeQuery = true)
    Usuario findActiveByUsername(String username);

    // Login simple (texto plano) — en producción usa BCrypt y Spring Security
    @Query(value = """
        SELECT * FROM USUARIO u
         WHERE UPPER(DBMS_LOB.SUBSTR(u.NOMBREUSUARIO, 4000)) = UPPER(:username)
           AND DBMS_LOB.SUBSTR(u.CONTRASENA, 4000) = :plainPassword
           AND u.ACTIVO = 1
      """, nativeQuery = true)
    Usuario loginPlain(String username, String plainPassword);
}
