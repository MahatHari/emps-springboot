package com.hari.ems.api.v1.request;

import com.hari.ems.core.domain.entity.UserAccount;
import com.hari.ems.core.domain.enums.DepartmentEnum;
import com.hari.ems.core.domain.enums.RoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

/**
 * @Author hari.mahat on 15.9.2024
 * Project ems
 */
@Getter
public class EmployeeRequest {
    @NotBlank(message = "Name is required")
    @Size(min=2, max=100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    private LocalDate dateOfBirth;
    @NotBlank(message = "Date of hiring is required")
    private LocalDate hireDate;
    @NotBlank(message = "Employee must be assigned to department")
    private DepartmentEnum department;

    @NotBlank(message = "Employee should have Role")
    private RoleEnum role;
    @NotBlank(message = "Should have username")
    private String username;
}
