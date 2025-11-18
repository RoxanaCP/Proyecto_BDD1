package com.ventaropa.venta.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ventaropa.venta.DTO.FacturaDetalleRes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VentaQueryService {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public FacturaDetalleRes obtenerFactura(Integer idFactura) {

        // ---------- 1) CABECERA ----------
        Object cab = em.createNativeQuery("""
                    SELECT f.idfacturaventa,
                           DBMS_LOB.SUBSTR(p.nombre, 4000) AS cliente,
                           DBMS_LOB.SUBSTR(t.descripcion, 4000) AS tipo_venta,
                           TO_CHAR(f.fecha, 'YYYY-MM-DD HH24:MI') AS fecha,
                           f.total
                    FROM factura_venta f
                    JOIN cliente c ON c.idcliente = f.idcliente
                    JOIN persona p ON p.idpersona = c.idpersona
                    JOIN tipo_venta t ON t.idtipoventa = f.idtipoventa
                    WHERE f.idfacturaventa = :id
                """)
                .setParameter("id", idFactura)
                .getSingleResult();

        Object[] cabArr = (Object[]) cab;

        FacturaDetalleRes res = new FacturaDetalleRes();

        res.setIdFactura(((Number) cabArr[0]).intValue());
        res.setCliente((String) cabArr[1]);
        res.setTipoVenta((String) cabArr[2]);
        res.setFecha((String) cabArr[3]);
        res.setTotal(cabArr[4] != null ? ((Number) cabArr[4]).doubleValue() : 0);

        // ---------- 2) DETALLES ----------
     List<Object[]> dets = em.createNativeQuery("""
            SELECT d.idproducto,
                   DBMS_LOB.SUBSTR(p.nombre, 4000),
                   d.cantidad,
                   d.preciounitario,
                   d.cantidad * d.preciounitario AS subtotal
            FROM detalle__factura d
            JOIN producto p ON p.idproducto = d.idproducto
            WHERE d.idfacturaventa = :id
        """)
        .setParameter("id", idFactura)
        .getResultList();


        List<FacturaDetalleRes.ItemDetalle> detList = dets.stream().map(r -> {
            FacturaDetalleRes.ItemDetalle item = new FacturaDetalleRes.ItemDetalle();
            item.setIdProducto(((Number) r[0]).intValue());
            item.setNombre((String) r[1]);
            item.setCantidad(((Number) r[2]).intValue());
            item.setPrecioUnitario(((Number) r[3]).doubleValue());
            item.setSubtotal(((Number) r[4]).doubleValue());
            return item;
        }).toList();

        res.setDetalles(detList);

        // ---------- 3) PAGOS ----------
        List<Object[]> pagos = em.createNativeQuery("""
                    SELECT p.idtipopago,
                           DBMS_LOB.SUBSTR(tp.descripcion, 4000),
                           p.monto
                    FROM pago p
                    JOIN tipo_pago tp ON tp.idtipopago = p.idtipopago
                    WHERE p.idfacturaventa = :id
                """)
                .setParameter("id", idFactura)
                .getResultList();

        List<FacturaDetalleRes.ItemPago> pagoList = pagos.stream().map(r -> {
            FacturaDetalleRes.ItemPago p = new FacturaDetalleRes.ItemPago();
            p.setIdTipoPago(((Number) r[0]).intValue());
            p.setTipoPago((String) r[1]);
            p.setMonto(((Number) r[2]).doubleValue());
            return p;
        }).toList();

        res.setPagos(pagoList);

        return res;
    }
}
