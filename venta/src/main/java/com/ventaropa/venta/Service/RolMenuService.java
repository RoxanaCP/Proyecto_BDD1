package com.ventaropa.venta.Service;

import com.ventaropa.venta.DTO.MenuConPermisosDto;
import com.ventaropa.venta.Repository.RolMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolMenuService {

    @Autowired
    private RolMenuRepository rolMenuRepository;

    public List<MenuConPermisosDto> obtenerMenusConPermisosPorRol(Integer idRol){
        return rolMenuRepository.findMenusConPermisosByRol(idRol);
    }
}
