package com.hari.ems.core.domain.entity;

import com.hari.ems.core.domain.enums.DepartmentEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private DepartmentEnum name;

    private String description;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees=new HashSet<>();

}
