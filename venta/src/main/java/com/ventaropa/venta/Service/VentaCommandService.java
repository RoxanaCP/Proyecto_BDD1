package com.ventaropa.venta.Service;

import com.ventaropa.venta.DTO.VentaCrearReq;
import com.ventaropa.venta.DTO.VentaCrearReq.Det;
import com.ventaropa.venta.DTO.VentaCrearRes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VentaCommandService {

  @PersistenceContext
  private EntityManager em;

  /**
   * @param req DTO con idCliente, idTipoVenta, idTipoPago y detalle[]
   * @param idEmpleadoSesion empleado logueado (se usa para determinar sucursal en el SP)
   */
 
   @Transactional
public VentaCrearRes crear(VentaCrearReq req, Integer idEmpleadoSesion) {
    try {
        // 1) CREAR_FACTURA (cabecera)
        StoredProcedureQuery spCab = em.createStoredProcedureQuery("VENTA_API.CREAR_FACTURA")
            .registerStoredProcedureParameter("p_idcliente",   Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_idtipoventa", Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_idsucursal",  Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_idempleado",  Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_idfactura",   Integer.class, ParameterMode.OUT);

        spCab.setParameter("p_idcliente",   req.getIdCliente());
        spCab.setParameter("p_idtipoventa", req.getIdTipoVenta());
        spCab.setParameter("p_idsucursal",  req.getIdSucursal());
        spCab.setParameter("p_idempleado",  idEmpleadoSesion);
        spCab.execute();

        Integer idFactura = (Integer) spCab.getOutputParameterValue("p_idfactura");

        // 2) AGREGAR_DETALLE (uno por renglón)
        for (Det d : req.getDetalle()) {
            StoredProcedureQuery spDet = em.createStoredProcedureQuery("VENTA_API.AGREGAR_DETALLE")
                .registerStoredProcedureParameter("p_idfactura",  Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_idproducto", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_cantidad",   Integer.class, ParameterMode.IN);

            spDet.setParameter("p_idfactura",  idFactura);
            spDet.setParameter("p_idproducto", d.getIdProducto());
            spDet.setParameter("p_cantidad",   d.getCantidad());
            spDet.execute(); // si aquí falta stock, el SP lanzará ORA-20001/20002 y se hará rollback
        }

        // 3) CERRAR_FACTURA (crea PAGO)
        StoredProcedureQuery spCierre = em.createStoredProcedureQuery("VENTA_API.CERRAR_FACTURA")
            .registerStoredProcedureParameter("p_idfactura",  Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_idtipopago", Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("p_idpago",     Integer.class, ParameterMode.OUT);

        spCierre.setParameter("p_idfactura",  idFactura);
        spCierre.setParameter("p_idtipopago", req.getIdTipoPago());
        spCierre.execute();

        Integer idPago = (Integer) spCierre.getOutputParameterValue("p_idpago");

        return new VentaCrearRes(idFactura, "Factura creada correctamente (pago " + idPago + ").");

    } catch (Exception e) {
        // Propaga como 400; el handler global limpiará el mensaje (ORA-2000x)
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
            e.getMessage() == null ? "No se pudo crear la factura." : e.getMessage());
    }
}
}
