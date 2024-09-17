package com.hari.ems.application.mapper;

import com.hari.ems.core.domain.dto.DepartmentDTO;
import com.hari.ems.core.domain.entity.Department;
import org.springframework.stereotype.Component;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
@Component
public class DepartmentMapper {

    public DepartmentDTO toDTO(Department department){
        if(department==null){
            return null;
        }

        DepartmentDTO dto= new DepartmentDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setDescription(department.getDescription());
        return dto;
    }

    public Department toEntity(DepartmentDTO departmentDTO){
        if(departmentDTO==null){
            return  null;
        }
        Department department=new Department();
        updateEntityFromDTO(departmentDTO, department);

        return department;
    }

    public void updateEntityFromDTO(DepartmentDTO dto, Department department){
        if(dto==null || department==null){
            return;
        }
        department.setName(dto.getName());
        department.setDescription(dto.getDescription());
    }
}
