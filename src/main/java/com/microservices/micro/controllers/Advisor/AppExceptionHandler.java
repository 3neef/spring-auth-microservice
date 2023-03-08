package com.microservices.micro.controllers.Advisor;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservices.micro.responses.BasicResponse;

@RestControllerAdvice

public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BasicResponse handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        return new BasicResponse("false","600",errorMap);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLException.class)
    public BasicResponse handleInvalidArgument(SQLException ex) {
        Map<String, String> errorMap = new HashMap<>();
        
            errorMap.put("sql error", ex.getMessage());
       

        return new BasicResponse("false","601",errorMap);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BasicResponse handleMissingBody(HttpMessageNotReadableException ex) {
        Map<String, String> errorMap = new HashMap<>();
        
            errorMap.put("Missing Body", ex.getMessage());
       

        return new BasicResponse("false","602",errorMap);
    }

}
