// src/main/java/com/ventaropa/venta/Repository/InventarioRepository.java
package com.ventaropa.venta.Repository;

import com.ventaropa.venta.Entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

    List<Inventario> findByIdBodegaOrderByIdInventarioAsc(Integer idBodega);

    List<Inventario> findByIdProductoOrderByIdInventarioAsc(Integer idProducto);

    Inventario findFirstByIdBodegaAndIdProducto(Integer idBodega, Integer idProducto);

    // Resumen total por producto (en todas las bodegas)
    interface ResumenProducto {
        Integer getIdProducto();
        Integer getTotal();
    }

    @Query(value = """
        SELECT IDPRODUCTO AS idProducto,
               SUM(EXISTENCIAPRODUCTO) AS total
          FROM INVENTARIO
         GROUP BY IDPRODUCTO
         ORDER BY IDPRODUCTO
    """, nativeQuery = true)
    List<ResumenProducto> resumenPorProducto();
}
