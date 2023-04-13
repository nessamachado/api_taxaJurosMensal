package com.vanessa.api_taxaJurosMensal.exceptions;

import com.vanessa.api_taxaJurosMensal.Generated;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Generated
@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler({
            EmptyResultDataAccessException.class,
            NullPointerException.class})
    public ResponseEntity errorNotFound(Exception e)  {
        return new ResponseEntity<>(new ExceptionError("Informação não encontrada"),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity errorBadRequest(Exception e){
        return new ResponseEntity<>(new ExceptionError("Solicitação incorreta"),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity errorMethodNotAllowed(Exception e){
        return new ResponseEntity<>(new ExceptionError("Método não suportado"),
                HttpStatus.METHOD_NOT_ALLOWED);
    }
}
