package com.ventaropa.venta.Config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.dao.DataIntegrityViolationException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.SQLGrammarException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // Solo devuelve {"message": "..."} con el status indicado
  private ResponseEntity<Object> json(int status, String msg) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("message", msg);
    return ResponseEntity.status(status).body(body);
  }

  // Obtiene el mensaje de la causa raíz
  private static String root(Throwable t) {
    Throwable cur = t;
    while (cur.getCause() != null && cur.getCause() != cur) cur = cur.getCause();
    return Optional.ofNullable(cur.getMessage()).orElse(t.toString());
  }

  // =================== Mapeos ===================

  // Maneja ResponseStatusException, pero siempre con mensaje corto
  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<Object> handleRse(ResponseStatusException ex) {
    // Si alguien lanzó RSE con message ya “bonito”, úsalo tal cual
    String msg = Optional.ofNullable(ex.getReason()).orElse("No se pudo completar la operación.");
    return json(ex.getStatusCode().value(), msg);
  }

  // Errores de BD “conocidos”
  @ExceptionHandler({
      DataIntegrityViolationException.class,
      ConstraintViolationException.class,
      SQLGrammarException.class
  })
  public ResponseEntity<Object> handleDbKnown(Exception ex) {
    return mapOracleOrGeneric(ex);
  }

  // Cualquier otro error
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleOthers(Exception ex, HttpServletRequest req) {
    return mapOracleOrGeneric(ex);
  }

  // =================== Lógica de mapeo mínima ===================

  private ResponseEntity<Object> mapOracleOrGeneric(Exception ex) {
    final String r = root(ex);
    if (r != null) {
      if (r.contains("ORA-20001")) { // stock insuficiente
        return json(400, "No hay existencia suficiente.");
      }
      if (r.contains("ORA-20002")) { // producto no disponible en la sucursal/bodega del empleado
        return json(400, "Producto no disponible en esta sucursal.");
      }
    }
    // Cualquier otro caso: mensaje genérico y corto
    return json(400, "No se pudo completar la operación.");
  }
}
