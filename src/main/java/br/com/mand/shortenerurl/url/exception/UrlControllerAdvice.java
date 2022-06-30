package br.com.mand.shortenerurl.url.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UrlControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Void> notFoundUrlShorty(){
        return ResponseEntity.notFound().build();
    }
}
