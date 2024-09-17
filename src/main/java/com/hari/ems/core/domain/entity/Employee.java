package com.hari.ems.core.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

/**
 * @Author hari.mahat on 14.9.2024
 * Project ems
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate hireDate;
    @Column(nullable = false)
    private LocalDate birthDate;

   @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserAccount userAccount;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "department_id", nullable = false)
    private Department department;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "role_id", nullable = false)
   private Role role;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        if (getId() != null ? !getId().equals(employee.getId()) : employee.getId() != null) return false;
        if (getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null) return false;
        if (getEmail() != null ? !getEmail().equals(employee.getEmail()) : employee.getEmail() != null) return false;
        return getDepartment() != null ? getDepartment().equals(employee.getDepartment()) : employee.getDepartment() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getDepartment() != null ? getDepartment().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
