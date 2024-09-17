package com.hari.ems.core.domain.dto;

import com.hari.ems.core.domain.entity.UserPermission;
import com.hari.ems.core.domain.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

/**
 * @Author hari.mahat on 17.9.2024
 * Project ems
 */
@Getter
@Setter
public class RoleDTO {
   private UUID id;
   private RoleEnum role;
   private String description;
   private Long employeeCount;
   private  Set<UserPermission> permissions;

    public RoleDTO(RoleEnum role) {
        this.role = role;
    }
}
