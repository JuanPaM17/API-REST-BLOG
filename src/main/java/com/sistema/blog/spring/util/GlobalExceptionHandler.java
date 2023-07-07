package com.sistema.blog.spring.util;

import com.sistema.blog.spring.excepciones.BlogAppException;
import com.sistema.blog.spring.excepciones.ResourcesNotFoundExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundExcepcion.class)
    public ResponseEntity<ErrorDetails> ResourceNoFoundException(ResourcesNotFoundExcepcion excepcion, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), excepcion.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND  );
    }

    @ExceptionHandler(BlogAppException.class)
    public ResponseEntity<ErrorDetails> BlogAppException(ResourcesNotFoundExcepcion excepcion, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), excepcion.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> GlobalException(ResourcesNotFoundExcepcion excepcion, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), excepcion.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
