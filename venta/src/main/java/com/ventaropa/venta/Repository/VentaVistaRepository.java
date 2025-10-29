package com.ventaropa.venta.Repository;

import com.ventaropa.venta.DTO.VentaVistaDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VentaVistaRepository {
    private final JdbcTemplate jdbcTemplate;

    public VentaVistaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<VentaVistaDTO> listarVentas() {
        String sql = """
            SELECT fv.IDFACTURAVENTA,
                   p.NOMBRE AS nombreCliente,
                   pa.NOMBRE AS pais,
                   s.NOMBRE AS sucursal,
                   te.DESCRIPCION AS estadoEnvio,
                   ee.FECHAENVIO,
                   ee.FECHAENTREGA,
                   fv.TOTAL
            FROM FACTURA_VENTA fv
            JOIN PERSONA p ON fv.IDCLIENTE = p.IDPERSONA
            JOIN SUCURSAL s ON fv.IDSUCURSAL = s.IDSUCURSAL
            JOIN PAIS pa ON s.IDPAIS = pa.IDPAIS
            JOIN ESTADO_ENVIO ee ON fv.IDFACTURAVENTA = ee.IDFACTURAVENTA
            JOIN TIPO_ESTADO te ON ee.IDTIPOESTADO = te.IDTIPOESTADO
            WHERE fv.IDTIPOVENTA = 2 -- por ejemplo, 2 = venta en línea
            ORDER BY fv.FECHA DESC
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            VentaVistaDTO v = new VentaVistaDTO();
            v.setIdFacturaVenta(rs.getInt("IDFACTURAVENTA"));
            v.setNombreCliente(rs.getString("nombreCliente"));
            v.setPais(rs.getString("pais"));
            v.setSucursal(rs.getString("sucursal"));
            v.setEstadoEnvio(rs.getString("estadoEnvio"));
            v.setFechaEnvio(rs.getDate("FECHAENVIO"));
            v.setFechaEntrega(rs.getDate("FECHAENTREGA"));
            v.setTotal(rs.getDouble("TOTAL"));
            return v;
        });
    }
}
