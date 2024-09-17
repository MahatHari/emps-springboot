package com.hari.ems.core.domain.entity;

import com.hari.ems.core.domain.enums.PermissionActionEnum;
import com.hari.ems.core.domain.enums.PermissionResourceEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */

@Data
@Entity
@Table(name = "user_permissions")
public class UserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PermissionActionEnum action;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PermissionResourceEnum resource;

    private  String description;


}
