package com.hari.ems.core.repository;

import com.hari.ems.core.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Author hari.mahat on 14.9.2024
 * Project ems
 */
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    boolean existsByEmail(String email);

    Optional<Employee> findByEmail(String email);

    List<Employee> findByDepartmentId(UUID departmentId);

    List<Employee> findByRoleId(UUID roleId);

    @Query("SELECT COUNT (e) FROM Employee  e where e.department.id=:departmentId")
    Long countByDepartmentId(@Param("departmentId") UUID departmentId);

    @Query("SELECT COUNT (e) FROM Employee e where e.role.id=:roleId")
    Long countByRoleId(@Param("roleId") UUID roleId);

}
