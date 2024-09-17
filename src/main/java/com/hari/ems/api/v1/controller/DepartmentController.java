package com.hari.ems.api.v1.controller;

import com.hari.ems.core.domain.dto.DepartmentDTO;
import com.hari.ems.core.domain.dto.EmployeeDTO;
import com.hari.ems.core.domain.entity.Department;
import com.hari.ems.core.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO createdDTO= departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        List<DepartmentDTO> departmentDTOS= departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentDTOS);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable UUID id, @RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO dto=  departmentService.updateDepartment(id, departmentDTO);
        return  ResponseEntity.ok(departmentDTO);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable UUID id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
