package com.qpolla.role.data.dto;

import com.qpolla.role.data.EnumRoleType;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoleDto implements Serializable {
    private Long id;

    private EnumRoleType role;
}
