package com.ventaropa.venta.Controller;

import com.ventaropa.venta.DTO.MenuConPermisosDto;
import com.ventaropa.venta.Service.RolMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rol-menu")
public class RolMenuController {

    @Autowired
    private RolMenuService rolMenuService;

    // Endpoint que ya usa tu menú.html
    @GetMapping("/menus-por-rol/{idRol}")
    public List<MenuConPermisosDto> menusPorRol(@PathVariable Integer idRol){
        return rolMenuService.obtenerMenusConPermisosPorRol(idRol);
    }
}
