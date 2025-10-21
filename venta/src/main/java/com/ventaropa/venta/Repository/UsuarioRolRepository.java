package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.UsuarioRol;
import com.ventaropa.venta.Entity.UsuarioRolId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRolId> {
    List<UsuarioRol> findByIdUsuario(Integer idUsuario);
}
