package com.qpolla.role.sevice;

import com.qpolla.role.data.EnumRoleType;
import com.qpolla.role.data.entity.RoleEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public RoleEntity findByType(EnumRoleType admin) {
        return null;
    }
}
