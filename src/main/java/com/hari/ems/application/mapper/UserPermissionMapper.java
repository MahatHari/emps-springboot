package com.hari.ems.application.mapper;

import com.hari.ems.core.domain.dto.UserPermissionDTO;
import com.hari.ems.core.domain.entity.UserPermission;
import org.springframework.stereotype.Component;

/**
 * @Author hari.mahat on 17.9.2024
 * Project ems
 */
@Component
public class UserPermissionMapper {

    public UserPermissionDTO toDTO(UserPermission permission){
        if(permission==null){
            return null;
        }
        UserPermissionDTO dto= new UserPermissionDTO();

        dto.setId(permission.getId());
        dto.setAction(permission.getAction());
        dto.setResource(permission.getResource());
        dto.setDescription(permission.getDescription());

        if(permission.getRole()!=null){
            dto.setRoleId(permission.getRole().getId());
        }
        return dto;
    }

    public UserPermission toEntity(UserPermissionDTO dto){
        if(dto==null){
            return  null;
        }

        UserPermission permission= new UserPermission();
        updateEntityFromDTO(dto,permission);
        return permission;

    }

    public  void updateEntityFromDTO(UserPermissionDTO dto, UserPermission permission){
        if(dto==null || permission==null){
            return ;
        }
        permission.setAction(dto.getAction());
        permission.setResource(dto.getResource());
        permission.setDescription(dto.getDescription());

    }
}
