package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Rol;
import com.ventaropa.venta.Entity.UsuarioRol;
import com.ventaropa.venta.Repository.RolRepository;
import com.ventaropa.venta.Repository.UsuarioRolRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RolService {
    private final RolRepository rolRepo;
    private final UsuarioRolRepository usuarioRolRepo;

    public RolService(RolRepository rolRepo, UsuarioRolRepository usuarioRolRepo){
        this.rolRepo = rolRepo; this.usuarioRolRepo = usuarioRolRepo;
    }

    public List<Rol> listar(){ return rolRepo.findAll(); }
    public Rol buscar(Integer id){ return rolRepo.findById(id).orElse(null); }

    // Roles asignados a un usuario
    public List<Rol> rolesPorUsuario(Integer idUsuario){
        List<UsuarioRol> cruces = usuarioRolRepo.findByIdUsuario(idUsuario);
        if (cruces.isEmpty()) return Collections.emptyList();

        List<Integer> idsRol = cruces.stream().map(UsuarioRol::getIdRol).distinct().toList();
        // preserva orden de aparición
        Map<Integer, Rol> byId = rolRepo.findAllById(idsRol).stream()
                .collect(Collectors.toMap(Rol::getIdRol, r->r));
        List<Rol> out = new ArrayList<>();
        for(Integer id: idsRol){ if(byId.containsKey(id)) out.add(byId.get(id)); }
        return out;
    }
}
