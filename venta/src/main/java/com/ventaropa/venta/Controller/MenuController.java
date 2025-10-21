package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Menu;
import com.ventaropa.venta.Service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/menus") @CrossOrigin(origins="*")
public class MenuController {
    private final MenuService service;
    public MenuController(MenuService service){ this.service = service; }

    @GetMapping public List<Menu> listar(){ return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> buscar(@PathVariable Integer id){
        Menu m = service.buscar(id);
        return (m!=null)? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }
}
