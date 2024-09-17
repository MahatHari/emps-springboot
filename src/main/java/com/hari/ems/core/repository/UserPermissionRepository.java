package com.hari.ems.core.repository;

import com.hari.ems.core.domain.entity.UserPermission;
import com.hari.ems.core.domain.enums.PermissionActionEnum;
import com.hari.ems.core.domain.enums.PermissionResourceEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
public interface UserPermissionRepository extends JpaRepository<UserPermission, UUID> {
    Optional<UserPermission> findByActionAndResource(PermissionActionEnum action, PermissionResourceEnum resourceEnum);
}
