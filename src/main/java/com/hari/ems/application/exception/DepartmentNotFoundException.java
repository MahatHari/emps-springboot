package com.hari.ems.application.exception;

import java.util.UUID;

/**
 * @Author hari.mahat on 17.9.2024
 * Project ems
 */
public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(UUID id){
        super("Department with id : "+id+ " not found");
    }

}
