package com.hari.ems.core.service;

import com.hari.ems.core.domain.dto.UserPermissionDTO;
import com.hari.ems.core.domain.enums.PermissionActionEnum;
import com.hari.ems.core.domain.enums.PermissionResourceEnum;

import java.util.List;
import java.util.UUID;

/**
 * @Author hari.mahat on 17.9.2024
 * Project ems
 */
public interface UserPermissionService {

    List<UserPermissionDTO> getAllPermissions();

    UserPermissionDTO getPermissionById(UUID id);

    UserPermissionDTO getUserPermissionByActionAndResource(PermissionActionEnum action, PermissionResourceEnum resourceEnum);

    UserPermissionDTO createUserPermission(UserPermissionDTO permissionDTO);

    UserPermissionDTO updateUserPermission(UUID id, UserPermissionDTO dto);

    void deleteUserPermission(UUID id);

    List<UserPermissionDTO> getUserPermissionByRoleId(UUID roleId);

    void assignUserPermissionToRole(UUID permissionId, UUID roleId);

    void removeUserPermissionFromRole(UUID permissionId, UUID roleId);

}
