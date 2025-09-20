package com.divisas.guardadito_go.microservice_ggo_cuentas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolationException;

import com.divisas.guardadito_go.microservice_ggo_cuentas.dto.response.ErrorResponse;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> detalles = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        
        ErrorResponse errorResponse = new ErrorResponse(
                "400.Pagos-Divisas-Guardadito-Go-Gestion-Cuentas.4000",
                "Datos de entrada inválidos",
                UUID.randomUUID().toString(),
                "https://baz-developer.bancoazteca.com.mx/info#400.Pagos-Divisas-Guardadito-Go-Gestion-Cuentas.4000",
                detalles
        );
        
        return ResponseEntity.badRequest().body(errorResponse);
    }
    
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorResponse> handleMissingHeader(MissingRequestHeaderException ex) {
        List<String> detalles = List.of("Header requerido: " + ex.getHeaderName());
        
        ErrorResponse errorResponse = new ErrorResponse(
                "400.Pagos-Divisas-Guardadito-Go-Gestion-Cuentas.4000",
                "Header requerido faltante",
                UUID.randomUUID().toString(),
                "https://baz-developer.bancoazteca.com.mx/info#400.Pagos-Divisas-Guardadito-Go-Gestion-Cuentas.4000",
                detalles
        );
        
        return ResponseEntity.badRequest().body(errorResponse);
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex) {
        List<String> detalles = ex.getConstraintViolations()
                .stream()
                .map(violation -> violation.getMessage())
                .collect(Collectors.toList());
        
        ErrorResponse errorResponse = new ErrorResponse(
                "400.Pagos-Divisas-Guardadito-Go-Gestion-Cuentas.4000",
                "Validación fallida",
                UUID.randomUUID().toString(),
                "https://baz-developer.bancoazteca.com.mx/info#400.Pagos-Divisas-Guardadito-Go-Gestion-Cuentas.4000",
                detalles
        );
        
        return ResponseEntity.badRequest().body(errorResponse);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        List<String> detalles = List.of("Error interno del servidor");
        
        ErrorResponse errorResponse = new ErrorResponse(
                "500.Pagos-Divisas-Guardadito-Go-Gestion-Cuentas.5000",
                "Error interno del servidor",
                UUID.randomUUID().toString(),
                "https://baz-developer.bancoazteca.com.mx/info#500.Pagos-Divisas-Guardadito-Go-Gestion-Cuentas.5000",
                detalles
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
