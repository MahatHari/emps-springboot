package com.hari.ems.core.service;

import com.hari.ems.core.domain.dto.EmployeeDTO;

import java.util.List;
import java.util.UUID;

/**
 * @Author hari.mahat on 14.9.2024
 * Project ems
 */
public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployee(UUID id);

    EmployeeDTO getEmployeeByEmail(String email);
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(UUID id, EmployeeDTO employeeDTO);
    void deleteEmployee(UUID id);

    EmployeeDTO assignDepartment(UUID employeeId, UUID departmentId);

    EmployeeDTO assignRole(UUID employeeId, UUID roleId);

    List<EmployeeDTO> getEmployeesByDepartment(UUID departmentId);

    List<EmployeeDTO> getEmployeesByRole(UUID roleId);

    Long getEmployeeCountByDepartment(UUID departmentId);

    Long getEmployeeCountByRole(UUID roleId);

}
