package com.hari.ems.core.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
@Data
@Entity
@Table(name = "user_accounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", unique = true)
    private  Employee employee;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false )
    private String passwordHash;

    private boolean isActive;
    private LocalDateTime lastLogin;
}
