package com.hari.ems.core.service.impl;

import com.hari.ems.application.exception.DuplicateEmailException;
import com.hari.ems.application.exception.EmployeeNotFoundException;
import com.hari.ems.application.mapper.EmployeeMapper;
import com.hari.ems.core.domain.dto.EmployeeDTO;
import com.hari.ems.core.domain.entity.Department;
import com.hari.ems.core.domain.entity.Employee;
import com.hari.ems.core.domain.entity.Role;
import com.hari.ems.core.repository.DepartmentRepository;
import com.hari.ems.core.repository.EmployeeRepository;
import com.hari.ems.core.repository.RoleRepository;
import com.hari.ems.core.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author hari.mahat on 14.9.2024
 * Project ems
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    private  final RoleRepository roleRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, DepartmentRepository departmentRepository,RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.departmentRepository=departmentRepository;
        this.roleRepository=roleRepository;
    }

    @Override
    @Transactional
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        if(employeeRepository.existsByEmail(employeeDTO.getEmail())){
            throw  new DuplicateEmailException(employeeDTO.getEmail());
        }
        Employee employee= employeeMapper.toEntity(employeeDTO);
        employee=employeeRepository.save(employee);
        return  employeeMapper.toDTo(employee);
    }

    @Override
    public EmployeeDTO getEmployee(UUID id) {
        Employee employee= employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found"));
        return  employeeMapper.toDTo(employee);
    }

    @Override
    public EmployeeDTO getEmployeeByEmail(String email) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map(employeeMapper::toDTo).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeDTO updateEmployee(UUID id, EmployeeDTO employeeDTO) {
        Employee employee= employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));

        /*
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(employeeDTO.getDepartment());
        return employeeMapper.toDTo(employee);
         */
        /* This will stop updated user's email to existing user email */
        if(employeeRepository.existsByEmail(employeeDTO.getEmail())){
            throw  new DuplicateEmailException(employeeDTO.getEmail());
        }
        employeeMapper.updateEntityFromDTO(employeeDTO, employee);
        employee=employeeRepository.save(employee);
        return employeeMapper.toDTo(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(UUID id) {
        if(!employeeRepository.existsById(id)){
            throw new EntityNotFoundException("Employee not found with id "+id);
        }
         employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public EmployeeDTO assignDepartment(UUID employeeId, UUID departmentId) {
        Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(()->new EntityNotFoundException("Employee not found with id "+ employeeId));

        Department department= departmentRepository.findById(departmentId)
                .orElseThrow(()->new EntityNotFoundException("Department not found with id "+ departmentId));

        employee.setDepartment(department);
        employee=employeeRepository.save(employee);
        return  employeeMapper.toDTo(employee);
    }

    @Override
    @Transactional
    public EmployeeDTO assignRole(UUID employeeId, UUID roleId) {
        Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(()->new EntityNotFoundException("Employee not found with id "+ employeeId));
        Role role= roleRepository.findById(roleId)
                .orElseThrow(()->new EntityNotFoundException("Role not found with id "+ roleId));
        employee.setRole(role);
        employeeRepository.save(employee);

        return employeeMapper.toDTo(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getEmployeesByDepartment(UUID departmentId) {

        return employeeRepository.findByDepartmentId(departmentId).stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional()
    public List<EmployeeDTO> getEmployeesByRole(UUID roleId) {

        return employeeRepository.findByRoleId(roleId)
                .stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Long getEmployeeCountByDepartment(UUID departmentId) {

        return employeeRepository.countByDepartmentId(departmentId);
    }

    @Override
    public Long getEmployeeCountByRole(UUID roleId) {
        return employeeRepository.countByRoleId(roleId);
    }
}
