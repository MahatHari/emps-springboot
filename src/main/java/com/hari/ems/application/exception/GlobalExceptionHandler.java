package com.hari.ems.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions (MethodArgumentNotValidException ex){
        Map<String, String> errors= new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->
                errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public  ResponseEntity<Map<String, String>> handleDuplicateEmailEception(DuplicateEmailException ex){
        Map<String, String> errors= new HashMap<>();
        errors.put("email", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);

    }
    @ExceptionHandler(DuplicateDepartmentException.class)
    public ResponseEntity<Map<String, String>> handleDupliceDepartmentException(DuplicateDepartmentException ex){
        Map<String, String> errors= new HashMap<>();
        errors.put("departmentName", ex.getMessage());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleDepartmentWithIdNotFoundException(DepartmentNotFoundException ex){
        Map<String, String> errors= new HashMap<>();
        errors.put("departmentId", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errors);
    }
}
