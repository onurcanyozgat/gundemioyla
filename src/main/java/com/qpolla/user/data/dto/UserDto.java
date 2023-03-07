package com.qpolla.user.data.dto;

import com.qpolla.role.data.dto.RoleDto;
import com.qpolla.user.data.EnumUserStatus;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto implements Serializable {
    private Long id;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @NotEmpty
    private String username;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    private List<RoleDto> roles = new ArrayList<>();

    private EnumUserStatus status;

    private long registeredDate;

    private long lastLoginDate;

    private long banBeginDate;

    private long banEndDate;

    private String ip;

    private byte[] avatar;

    private String url;

    private int pollCounter;
}
