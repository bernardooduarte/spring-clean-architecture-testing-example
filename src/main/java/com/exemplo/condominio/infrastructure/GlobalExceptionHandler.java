package com.exemplo.condominio.infrastructure;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleNegocioException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(Map.of(
                "erro", "Violação de regra de negócio",
                "mensagem", ex.getMessage()
        ));
    }
}