package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Usuario;
import com.ventaropa.venta.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Lecturas
    public Usuario buscarUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarActivoPorUsername(String username) {
        return usuarioRepository.findActiveByUsername(username);
    }

    // Login (texto plano para pruebas)
    public Usuario login(String username, String plainPassword) {
        return usuarioRepository.loginPlain(username, plainPassword);
    }
}
