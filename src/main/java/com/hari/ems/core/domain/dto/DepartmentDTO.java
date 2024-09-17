package com.hari.ems.core.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hari.ems.api.v1.controller.EmployeeController;
import com.hari.ems.core.domain.enums.DepartmentEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentDTO {
    private UUID id;
    @NotNull(message = "Department name is required")
    private DepartmentEnum name;
    private String description;
    private Long employeeCount;

    private List<EmployeeDTO> employees;
    public DepartmentDTO(DepartmentEnum name){
        this.name=name;
    }
}
