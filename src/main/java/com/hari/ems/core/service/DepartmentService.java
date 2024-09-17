package com.hari.ems.core.service;

import com.hari.ems.core.domain.dto.DepartmentDTO;
import com.hari.ems.core.domain.enums.DepartmentEnum;

import java.util.List;
import java.util.UUID;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
public interface DepartmentService {
    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartmentByName(DepartmentEnum name);

    DepartmentDTO createDepartment(DepartmentDTO dto);

    DepartmentDTO updateDepartment(UUID name, DepartmentDTO dto);


    void deleteDepartment(UUID id);
}
