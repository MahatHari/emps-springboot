package com.hari.ems.application.mapper;

import com.hari.ems.api.v1.request.EmployeeRequest;
import com.hari.ems.core.domain.dto.EmployeeDTO;
import com.hari.ems.core.domain.entity.Department;
import com.hari.ems.core.domain.entity.Employee;
import com.hari.ems.core.domain.entity.Role;
import com.hari.ems.core.domain.entity.UserAccount;
import com.hari.ems.core.domain.enums.DepartmentEnum;
import com.hari.ems.core.domain.enums.RoleEnum;
import com.hari.ems.core.repository.DepartmentRepository;
import com.hari.ems.core.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * @Author hari.mahat on 14.9.2024
 * Project ems
 */
@Component
public class EmployeeMapper {

    private final DepartmentRepository departmentRepository;
    private final RoleRepository roleRepository;

    public EmployeeMapper(DepartmentRepository departmentRepository, RoleRepository roleRepository) {
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
    }

    public EmployeeDTO toDTo(Employee employee){
        if (employee==null){
            return null;
        }
        EmployeeDTO dto= new EmployeeDTO();
                dto.setId(employee.getId());
                dto.setName(employee.getName());
                dto.setEmail(employee.getEmail());
                dto.setDateOfBirth(employee.getBirthDate());
                dto.setHireDate(employee.getHireDate());
                if(employee.getDepartment() !=null){
                    dto.setDepartment(employee.getDepartment().getName());
                }
                if(employee.getRole()!=null){
                    dto.setRole(employee.getRole().getName());
                }
                if (employee.getUserAccount()!=null){
                    dto.setUsername(employee.getUserAccount().getUsername());
                }
                return  dto;
    }
    public EmployeeDTO toDTo(EmployeeRequest employeeRequest){
        EmployeeDTO dto= new EmployeeDTO();
        dto.setName(employeeRequest.getName());
        dto.setEmail(employeeRequest.getEmail());
        dto.setDateOfBirth(employeeRequest.getDateOfBirth());
        dto.setHireDate(employeeRequest.getHireDate());
        if(employeeRequest.getDepartment() !=null){
            dto.setDepartment(employeeRequest.getDepartment());
        }
        if(employeeRequest.getRole()!=null){
            dto.setRole(employeeRequest.getRole());
        }
        if (employeeRequest.getUsername()!=null){
            dto.setUsername(employeeRequest.getUsername());
        }
        return dto;
    }

    public Employee toEntity(EmployeeDTO dto){
        if(dto==null){
            return null;
        }
        Employee employee= new Employee();
        updateEntityFromDTO(dto, employee);
        return employee;
    }


    public  void updateEntityFromDTO(EmployeeDTO dto, Employee employee){
        if(dto==null || employee==null){
            return;
        }
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setBirthDate(dto.getDateOfBirth());
        employee.setHireDate(dto.getHireDate());

        // Handle Department
        if(dto.getDepartment()!=null){
            Department department= getDepartmentByEnum(dto.getDepartment());
            employee.setDepartment(department);
        }else {
            employee.setDepartment(null);
        }
        if(dto.getRole() !=null){
            Role role= getRoleByEnum(dto.getRole());
            employee.setRole(role);
        }

        if(dto.getUsername()!=null){
            UserAccount userAccount= employee.getUserAccount();
            if(userAccount==null){
                userAccount= new UserAccount();
                userAccount.setEmployee(employee);
                employee.setUserAccount(userAccount);

            }
            userAccount.setUsername(dto.getUsername());
        }
    }

    private Role getRoleByEnum(RoleEnum role) {
        return roleRepository.findByName(role)
                .orElseThrow(()-> new EntityNotFoundException("Role not found"));

    }

    public Department getDepartmentByEnum(DepartmentEnum departmentEnum){
        return departmentRepository.findByName(departmentEnum)
                .orElseThrow(()-> new EntityNotFoundException("Department not Found :"+ departmentEnum));
    }

    public EmployeeDTO toDTO(EmployeeRequest employeeRequest, UUID id){
        EmployeeDTO dto= toDTo(employeeRequest);
        dto.setId(id);
        return dto;
    }
    public EmployeeDTO toDTO(Employee employee){
        return toDTo(employee);
    }
    public void updateEmployeeFromDTO(EmployeeDTO employeeDTO, Employee employee){
        if(employeeDTO==null || employee==null){
            return;
        }
        Optional.ofNullable(employeeDTO.getName()).ifPresent(employee::setName);
        Optional.of(employeeDTO.getEmail()).ifPresent(employee::setEmail);
        Optional.ofNullable(employeeDTO.getHireDate()).ifPresent(employee::setHireDate);
        Optional.ofNullable(employeeDTO.getDateOfBirth()).ifPresent(employee::setBirthDate);

        if(employeeDTO.getDepartment()!=null){
            Department department= getDepartmentByEnum(employeeDTO.getDepartment());
            employee.setDepartment(department);
        }
        if(employeeDTO.getRole()!=null){
            Role role= getRoleByEnum(employeeDTO.getRole());
            employee.setRole(role);
        }
        if(employeeDTO.getUsername()!=null){
            UserAccount userAccount= employee.getUserAccount();
            if(userAccount==null){
                userAccount= new UserAccount();
                userAccount.setEmployee(employee);
                employee.setUserAccount(userAccount);
            }
            userAccount.setUsername(employeeDTO.getUsername());
        }
    }

}
