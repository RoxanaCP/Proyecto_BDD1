package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Menu;
import com.ventaropa.venta.Repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository repo;
    public MenuService(MenuRepository repo){ this.repo = repo; }

    public List<Menu> listar(){ return repo.findAll(); }
    public Menu buscar(Integer id){ return repo.findById(id).orElse(null); }
}
