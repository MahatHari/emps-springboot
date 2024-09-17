package com.hari.ems.core.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hari.ems.core.domain.enums.PermissionActionEnum;
import com.hari.ems.core.domain.enums.PermissionResourceEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @Author hari.mahat on 17.9.2024
 * Project ems
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPermissionDTO {
    private UUID id;

    @NotNull(message = "Action is required" )
    private PermissionActionEnum action;

    @NotNull(message = "Resource is required")
    private PermissionResourceEnum resource;

    private  String description;

    private UUID roleId;
}
