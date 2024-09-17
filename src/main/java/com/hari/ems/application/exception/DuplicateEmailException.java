package com.hari.ems.application.exception;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
public class DuplicateEmailException extends  RuntimeException {
    public DuplicateEmailException(String email){
        super("Email alrady exists :"+email);
    }
}
