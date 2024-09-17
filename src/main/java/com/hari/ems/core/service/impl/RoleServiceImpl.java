package com.hari.ems.core.service.impl;

import com.hari.ems.application.mapper.RoleMapper;
import com.hari.ems.core.domain.dto.RoleDTO;
import com.hari.ems.core.repository.RoleRepository;
import com.hari.ems.core.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author hari.mahat on 17.9.2024
 * Project ems
 */
@Service
public class RoleServiceImpl implements RoleService {

    private  final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return null;
    }

    @Override
    public RoleDTO getRoleById(UUID id) {
        return null;
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        return null;
    }

    @Override
    public RoleDTO updateRole(UUID id, RoleDTO roleDTO) {
        return null;
    }

    @Override
    public void deleteRole(UUID id) {

    }
}
