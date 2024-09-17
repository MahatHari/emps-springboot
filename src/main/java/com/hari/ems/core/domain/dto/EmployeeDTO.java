package com.hari.ems.core.domain.dto;

import com.hari.ems.core.domain.enums.DepartmentEnum;
import com.hari.ems.core.domain.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.PrimitiveIterator;
import java.util.UUID;

/**
 * @Author hari.mahat on 14.9.2024
 * Project ems
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private UUID id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate hireDate;
    private DepartmentEnum department;
    private RoleEnum role;
    private String username;
}
