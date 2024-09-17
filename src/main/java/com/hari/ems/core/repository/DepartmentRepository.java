package com.hari.ems.core.repository;

import com.hari.ems.core.domain.entity.Department;
import com.hari.ems.core.domain.enums.DepartmentEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    Optional<Department> findByName(DepartmentEnum departmentEnum);

    Boolean existsByName(DepartmentEnum departmentEnum);
    @Query("SELECT COUNT(e) FROM Employee  e where e.department.id= :departmentId")
    Long countEmployeesByDepartmentId(@Param("departmentId") UUID departmentId);
}
