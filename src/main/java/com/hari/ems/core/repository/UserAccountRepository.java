package com.hari.ems.core.repository;

import com.hari.ems.core.domain.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @Author hari.mahat on 16.9.2024
 * Project ems
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, UUID> {
}
