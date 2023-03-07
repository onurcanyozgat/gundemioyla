package com.qpolla.role.sevice;

import com.qpolla.role.data.EnumRoleType;
import com.qpolla.role.data.entity.RoleEntity;

public interface RoleService {
    RoleEntity findByType(EnumRoleType admin);
}
