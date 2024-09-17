package com.hari.ems.core.service;

import com.hari.ems.core.domain.dto.RoleDTO;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

/**
 * @Author hari.mahat on 17.9.2024
 * Project ems
 */
public interface RoleService {

    /**
     * Retrieves all roles
     * @return List<RoleDTO>, return list of RoleDTO
     */
    List<RoleDTO> getAllRoles();

    /**
     * Retrieves a role by its name.
     * @param id The uuid of the role
     * @return RoleDTO
     * @throws EntityNotFoundException if the role is not found.
     */
    RoleDTO getRoleById(UUID id);

    /**
     * Creates a new role.
     * @param roleDTO the role data to create
     * @return the created DTO
     */
    RoleDTO createRole(RoleDTO roleDTO);

    /**
     * Updates existing role
     * @param id The ID of the role to update
     * @param roleDTO the updated role data.
     * @return The update role DTO
     * @throws EntityNotFoundException if the role is not found
     */
    RoleDTO updateRole(UUID id, RoleDTO roleDTO);

    /**
     * Delete a role.
     *
     * @param id, The ID of the role to delete
     * @throws EntityNotFoundException if the role is not found.
     *
     */
    void deleteRole(UUID id);
}
