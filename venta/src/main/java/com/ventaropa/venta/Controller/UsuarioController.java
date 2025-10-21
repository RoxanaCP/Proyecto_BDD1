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

    // ---- PING
    @GetMapping("_ping")
    public String ping() { return "usuarios-ok"; }

    
    
    // ---- LOGIN (POST)  ✅ ESTE ES EL QUE TE FALTABA
    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> login(@RequestBody LoginRequest body) {
        if (body == null || body.getUsername() == null || body.getPassword() == null) {
            return ResponseEntity.badRequest().body("Faltan credenciales");
        }
        Usuario u = usuarioService.login(body.getUsername(), body.getPassword());
        if (u == null) {
            return ResponseEntity.status(401).body("Credenciales inválidas o usuario inactivo");
        }
        return ResponseEntity.ok(new LoginResponse(u.getIdUsuario(), u.getNombreUsuario(), u.getActivo()));
    }

    // (Opcional) SEGUNDO PATH PARA PROBAR RÁPIDO
    @PostMapping(value = "/signin", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> signin(@RequestBody LoginRequest body) {
        return login(body);
    }

    // ---- DTOs
    public static class LoginRequest {
        private String username;
        private String password;
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
    public static class LoginResponse {
        private Integer idUsuario;
        private String nombreUsuario;
        private Short activo;
        public LoginResponse(Integer idUsuario, String nombreUsuario, Short activo) {
            this.idUsuario = idUsuario; this.nombreUsuario = nombreUsuario; this.activo = activo;
        }
        public Integer getIdUsuario() { return idUsuario; }
        public String getNombreUsuario() { return nombreUsuario; }
        public Short getActivo() { return activo; }
    }
}
