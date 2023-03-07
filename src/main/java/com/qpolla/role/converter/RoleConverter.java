package com.qpolla.role.converter;

import com.qpolla.role.data.dto.RoleDto;
import com.qpolla.role.data.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
    public RoleDto toDto(RoleEntity source) {
        RoleDto target = new RoleDto();
        return target;
    }

    public RoleEntity toEntity(RoleDto source) {
        RoleEntity target = new RoleEntity();
        return target;
    }
}
