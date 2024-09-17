package com.hari.ems.core.service.impl;

import com.hari.ems.application.exception.DepartmentNotFoundException;
import com.hari.ems.application.exception.DuplicateDepartmentException;
import com.hari.ems.application.mapper.DepartmentMapper;
import com.hari.ems.core.domain.dto.DepartmentDTO;
import com.hari.ems.core.domain.entity.Department;
import com.hari.ems.core.domain.enums.DepartmentEnum;
import com.hari.ems.core.repository.DepartmentRepository;
import com.hari.ems.core.service.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(this::enrichedDepartmentDTO)
                .collect(Collectors.toList());
    }


    @Override
    public DepartmentDTO getDepartmentByName(DepartmentEnum name) {
        Department department= departmentRepository.findByName(name)
                .orElseThrow(()-> new EntityNotFoundException("Department with name: "+ name +" not found."));
        return enrichedDepartmentDTO(department);
    }

    @Override
    @Transactional
    public DepartmentDTO createDepartment(DepartmentDTO dto) {
        if(departmentRepository.existsByName(dto.getName())){
            throw new DuplicateDepartmentException(dto.getName());
        }
        Department department= departmentMapper.toEntity(dto);
        department=departmentRepository.save(department);
        return enrichedDepartmentDTO(department);
    }

    @Override
    @Transactional
    public DepartmentDTO updateDepartment(UUID id, DepartmentDTO dto) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(()-> new DepartmentNotFoundException(id));

        departmentMapper.updateEntityFromDTO(dto, department);

        department= departmentRepository.save(department);
        return enrichedDepartmentDTO(department);

    }

    @Override
    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);

    }

    private DepartmentDTO enrichedDepartmentDTO(Department department){
        DepartmentDTO dto= departmentMapper.toDTO(department);
        dto.setEmployeeCount(departmentRepository.countEmployeesByDepartmentId(department.getId()));
        return dto;
    }
}
