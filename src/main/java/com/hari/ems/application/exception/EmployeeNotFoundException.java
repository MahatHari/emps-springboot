package com.hari.ems.application.exception;

import java.util.UUID;

/**
 * @Author hari.mahat on 14.9.2024
 * Project ems
 */
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(UUID id){
        super("Employee with id "+ id + " not found");
    }
}
