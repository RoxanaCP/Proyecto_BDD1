// src/main/java/com/ventaropa/venta/Service/FacturaVentaService.java
package com.ventaropa.venta.Service;

import com.ventaropa.venta.DTO.FacturaVentaDTO;
import com.ventaropa.venta.Entity.Empleado;
import com.ventaropa.venta.Entity.FacturaVenta;
import com.ventaropa.venta.Repository.FacturaVentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaVentaService {

    private final FacturaVentaRepository repo;

    @Autowired
    EmpleadoService repoEmpleado;

    @Autowired
    SucursalService repoSucursal;

    @Autowired
    ClienteService repoCliente;

    public FacturaVentaService(FacturaVentaRepository repo) {
        this.repo = repo;
    }

    public List<FacturaVenta> listar() {
        return repo.findAll();
    }

    public FacturaVenta buscar(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public List<FacturaVenta> porCliente(Integer idCliente) {
        return repo.findByIdCliente(idCliente);
    }

    public List<FacturaVenta> porSucursal(Integer idSucursal) {
        return repo.findByIdSucursal(idSucursal);
    }

    public List<FacturaVenta> porRango(Date desde, Date hasta) {
        return repo.findByFechaEntre(desde, hasta);
    }

    public List<FacturaVenta> porDia(Date dia) {
        return repo.findByFechaDia(dia);
    }


    public List<FacturaVentaDTO> obtenerFacturasConNombres() {
    List<FacturaVenta> facturas = repo.findAll();
    List<FacturaVentaDTO> facturasVista = new ArrayList<>();

    for (FacturaVenta facturaVenta : facturas) {
        Integer idFacturaVenta = facturaVenta.getIdFacturaVenta();
        Integer idPago = facturaVenta.getIdPago();
        String nombreTipoVenta = facturaVenta.getIdTipoVenta() == 1 ? "FÍSICA" : "EN LÍNEA";

        // Empleado
        String nombreEmpleado = null;
        try {
            nombreEmpleado = repoEmpleado.buscar(facturaVenta.getIdEmpleado());
        } catch (Exception e) {
            nombreEmpleado = "Desconocido";
        }

        // Sucursal
        String nombreSucursal = null;
        nombreSucursal = repoSucursal.buscarPorId(facturaVenta.getIdSucursal()).getNombre();

        /*try {
            System.out.println("EL NOMBRE DE LA SUCURAL ES: "+repoSucursal.buscarPorId(facturaVenta.getIdSucursal()).getNombre());
            var sucursal = repoSucursal.buscarPorId(facturaVenta.getIdSucursal());
            nombreSucursal = (sucursal != null) ? sucursal.getNombre() : "Desconocida";
        } catch (Exception e) {
            nombreSucursal = "Desconocida";
        }*/

        // Cliente
        String nombreCliente = null;
        try {
            nombreCliente = repoCliente.buscar(facturaVenta.getIdCliente());
        } catch (Exception e) {
            nombreCliente = "Desconocido";
        }

        Date fecha = facturaVenta.getFecha();
        Integer total = facturaVenta.getTotal();

        FacturaVentaDTO factNew = new FacturaVentaDTO(
            idFacturaVenta,
            idPago,
            nombreTipoVenta,
            nombreEmpleado,
            nombreSucursal,
            nombreCliente,
            fecha,
            total
        );
        facturasVista.add(factNew);
    }

    return facturasVista;
}
}
