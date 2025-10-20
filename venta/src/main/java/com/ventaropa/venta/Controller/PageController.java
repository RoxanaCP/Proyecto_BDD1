package com.ventaropa.venta.Controller;  // Asegúrate de que esté en el paquete correcto

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/ingresosProductos")
    public String ingresosProductos() {
        return "ingresosProductos";  // Spring Boot buscará ingresosProductos.html en la carpeta templates
    }
}
