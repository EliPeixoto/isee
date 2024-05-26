package br.com.fiap.isee.controller;

import br.com.fiap.isee.entities.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    private StandardError erro = new StandardError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandardError>entityNotFound(
            ControllerNotFoundException e,
            HttpServletRequest request){

        HttpStatus status =  HttpStatus.NOT_FOUND;
        erro.setTimestamp(Instant.now());
        erro.setStatus(status.value());
        erro.setError("Entity not Found");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(this.erro);
    }
}
