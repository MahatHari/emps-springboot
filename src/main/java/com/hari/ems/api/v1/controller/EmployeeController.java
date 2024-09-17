package com.hari.ems.api.v1.controller;

import com.hari.ems.api.v1.request.EmployeeRequest;
import com.hari.ems.application.mapper.EmployeeMapper;
import com.hari.ems.core.domain.dto.EmployeeDTO;
import com.hari.ems.core.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @Author hari.mahat on 15.9.2024
 * Project ems
 */

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private  final EmployeeMapper employeeMapper;


    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper=employeeMapper;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee (@Valid @RequestBody EmployeeRequest employeeRequest){
        EmployeeDTO employeeDTO= employeeMapper.toDTo(employeeRequest);
        EmployeeDTO createdEmployee= employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);


    }

    @GetMapping("{id}")
    public  ResponseEntity<EmployeeDTO> getEmployee(@PathVariable UUID id){
        EmployeeDTO employee= employeeService.getEmployee(id);
        return ResponseEntity.ok(employee);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO>  employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable UUID id, @RequestBody EmployeeRequest employeeRequest){
        EmployeeDTO  employeeDTO = employeeMapper.toDTO(employeeRequest, id);
        EmployeeDTO updatedEmployeeDTO= employeeService.updateEmployee(id, employeeDTO);
        return ResponseEntity.ok(updatedEmployeeDTO);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
