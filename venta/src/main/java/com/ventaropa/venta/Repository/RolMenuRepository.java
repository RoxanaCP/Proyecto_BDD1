package com.ventaropa.venta.Repository;

import com.ventaropa.venta.DTO.MenuConPermisosDto;
import com.ventaropa.venta.Entity.RolMenu;
import com.ventaropa.venta.Entity.RolMenuId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolMenuRepository extends JpaRepository<RolMenu, RolMenuId> {

    // Por si quieres ver crudo los vínculos
    List<RolMenu> findByIdRol(Integer idRol);

    // Lo que usa tu vista: MENÚS del rol + permisos (ALTA/BAJA/CAMBIO)
    @Query(value = """
        SELECT 
           m.IDMENU     AS idMenu,
           m.IDMODULO   AS idModulo,
           DBMS_LOB.SUBSTR(m.NOMBREMENU, 4000) AS nombreMenu,
           rm.ALTA      AS alta,
           rm.BAJA      AS baja,
           rm.CAMBIO    AS cambio
        FROM ROL_MENU rm
        JOIN MENU m ON m.IDMENU = rm.IDMENU
        WHERE rm.IDROL = :idRol
        ORDER BY m.IDMENU
        """, nativeQuery = true)
    List<MenuConPermisosDto> findMenusConPermisosByRol(Integer idRol);
}
