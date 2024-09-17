package com.hari.ems.application.exception;

import com.hari.ems.core.domain.enums.DepartmentEnum;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
public class DuplicateDepartmentException extends  RuntimeException {
    public DuplicateDepartmentException(DepartmentEnum departmentName){
        super("Department: "+ departmentName +"  already exists");
    }
}
