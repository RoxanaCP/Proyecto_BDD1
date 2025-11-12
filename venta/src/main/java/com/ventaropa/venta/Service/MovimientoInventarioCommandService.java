// MovimientoInventarioCommandService.java
package com.ventaropa.venta.Service;

import com.ventaropa.venta.DTO.MovimientoInventarioReq;
import com.ventaropa.venta.DTO.MovimientoInventarioRes;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// MovimientoInventarioCommandService.java
// MovimientoInventarioCommandService.java
@Service
public class MovimientoInventarioCommandService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public MovimientoInventarioRes registrarMovimiento(MovimientoInventarioReq req) {

        StoredProcedureQuery sp = em
            .createStoredProcedureQuery("INV_API.REGISTRAR_MOVIMIENTO")
            .registerStoredProcedureParameter("p_idusuario",  Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_idbodega",   Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_idproducto", Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_idtipomov",  Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_cantidad",   Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_fecha",      java.sql.Date.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_idmov",      Integer.class, ParameterMode.OUT);

        sp.setParameter("p_idusuario",  req.getIdUsuario());
        sp.setParameter("p_idbodega",   req.getIdBodega());
        sp.setParameter("p_idproducto", req.getIdProducto());
        sp.setParameter("p_idtipomov",  req.getIdTipoMovimiento());
        sp.setParameter("p_cantidad",   req.getCantidad());

        // Si mandas "fecha" en el JSON como "YYYY-MM-DD"
        java.sql.Date fechaSql = null;
        if (req.getFecha() != null && !req.getFecha().isEmpty()) {
            fechaSql = java.sql.Date.valueOf(req.getFecha()); // LocalDate.parse(...) -> java.sql.Date
        }
        sp.setParameter("p_fecha", fechaSql); // null = SYSDATE en el SP

        sp.execute();

        Integer nuevoId = (Integer) sp.getOutputParameterValue("p_idmov");
        return new MovimientoInventarioRes(nuevoId, "Movimiento registrado correctamente.");
    }
}
