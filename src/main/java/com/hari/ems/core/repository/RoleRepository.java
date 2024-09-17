package com.hari.ems.core.repository;

import com.hari.ems.core.domain.entity.Role;
import com.hari.ems.core.domain.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
public interface RoleRepository extends JpaRepository<Role, UUID> {
   Optional<Role>  findByName(RoleEnum role);
}
