package com.hari.ems.core.service.impl;

import com.hari.ems.application.mapper.UserPermissionMapper;
import com.hari.ems.core.domain.dto.UserPermissionDTO;
import com.hari.ems.core.domain.entity.UserPermission;
import com.hari.ems.core.domain.enums.PermissionActionEnum;
import com.hari.ems.core.domain.enums.PermissionResourceEnum;
import com.hari.ems.core.repository.RoleRepository;
import com.hari.ems.core.repository.UserPermissionRepository;
import com.hari.ems.core.service.UserPermissionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author hari.mahat on 17.9.2024
 * Project ems
 */
@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    private final UserPermissionRepository userPermissionRepository;
    private final RoleRepository roleRepository;
    private final UserPermissionMapper permissionMapper;


    public UserPermissionServiceImpl(UserPermissionRepository userPermissionRepository, RoleRepository roleRepository, UserPermissionMapper permissionMapper) {
        this.userPermissionRepository = userPermissionRepository;
        this.roleRepository = roleRepository;
        this.permissionMapper = permissionMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserPermissionDTO> getAllPermissions() {
        List<UserPermissionDTO> dto= userPermissionRepository.findAll()
                .stream()
                .map(permissionMapper::toDTO)
                .toList();
        return dto;

    }

    @Override
    @Transactional(readOnly = true)
    public UserPermissionDTO getPermissionById(UUID id) {

        UserPermission permission= userPermissionRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Permssion not found "+ id));

        return permissionMapper.toDTO(permission);
    }

    @Override
    @Transactional(readOnly = true)
    public UserPermissionDTO getUserPermissionByActionAndResource(PermissionActionEnum action, PermissionResourceEnum resourceEnum) {

        UserPermission permission= userPermissionRepository.findByActionAndResource(action, resourceEnum)
                .orElseThrow(()-> new EntityNotFoundException("Permission not found for action "+ action + " and resource "+ resourceEnum));

        return permissionMapper.toDTO(permission);
    }

    @Override
    public UserPermissionDTO createUserPermission(UserPermissionDTO permissionDTO) {

        UserPermission permission= permissionMapper.toEntity(permissionDTO);
        permission=userPermissionRepository.save(permission);
        return  permissionMapper.toDTO(permission);

    }

    @Override
    public UserPermissionDTO updateUserPermission(UUID id, UserPermissionDTO dto) {
        return null;
    }

    @Override
    public void deleteUserPermission(UUID id) {
        userPermissionRepository.deleteById(id);
    }

    @Override
    public List<UserPermissionDTO> getUserPermissionByRoleId(UUID roleId) {
        return null;
    }

    @Override
    public void assignUserPermissionToRole(UUID permissionId, UUID roleId) {

    }

    @Override
    public void removeUserPermissionFromRole(UUID permissionId, UUID roleId) {

    }
}
