package com.ventaropa.venta.Controller;

import com.ventaropa.venta.Entity.Usuario;
import com.ventaropa.venta.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // ====== CONSULTAS (read-only) ======
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> buscar(@PathVariable Integer idUsuario) {
        Usuario u = usuarioService.buscarUsuario(idUsuario);
        return (u != null) ? ResponseEntity.ok(u) : ResponseEntity.notFound().build();
    }

    @GetMapping("/by-username/{username}")
    public ResponseEntity<Usuario> buscarPorUsername(@PathVariable String username) {
        Usuario u = usuarioService.buscarActivoPorUsername(username);
        return (u != null) ? ResponseEntity.ok(u) : ResponseEntity.notFound().build();
    }

    @GetMapping("_ping")
public String ping() {
  return "usuarios-ok";
}


}
