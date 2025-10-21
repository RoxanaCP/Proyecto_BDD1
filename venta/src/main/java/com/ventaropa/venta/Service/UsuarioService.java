package com.ventaropa.venta.Service;

import com.ventaropa.venta.Entity.Usuario;
import com.ventaropa.venta.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  public Usuario login(String username, String plainPassword) {
    String sha = sha256Hex(plainPassword);
    System.out.println("el sha es: :::::::::::::::::"+sha);
    return usuarioRepository.loginByUsernameAndSha(username, sha);
  }

  private String sha256Hex(String text) {
    try {
      var md = java.security.MessageDigest.getInstance("SHA-256");
      byte[] dig = md.digest(text.getBytes(java.nio.charset.StandardCharsets.UTF_8));
      StringBuilder sb = new StringBuilder(dig.length * 2);
      for (byte b : dig) sb.append(String.format(java.util.Locale.ROOT, "%02x", b));
      return sb.toString();
    } catch (Exception e) {
      throw new RuntimeException("No se pudo calcular SHA-256", e);
    }
  }
}
