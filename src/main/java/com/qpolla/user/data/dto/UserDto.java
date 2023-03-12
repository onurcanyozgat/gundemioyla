package com.qpolla.user.data.dto;

import com.qpolla.role.data.dto.RoleDto;
import com.qpolla.user.data.EnumUserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Serializable {
    private Long id;

    private String email;

    private String username;

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

    public UserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
