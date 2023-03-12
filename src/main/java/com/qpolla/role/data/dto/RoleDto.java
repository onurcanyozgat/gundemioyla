package com.qpolla.role.data.dto;

import com.qpolla.role.data.EnumRoleType;
import com.qpolla.user.data.dto.UserDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RoleDto implements Serializable {
    private Long id;

    private EnumRoleType role;

    private List<UserDto> users;
}
