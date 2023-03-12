package com.qpolla.role.repository;

import com.qpolla.role.data.EnumRoleType;
import com.qpolla.role.data.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRole(EnumRoleType role);
}
