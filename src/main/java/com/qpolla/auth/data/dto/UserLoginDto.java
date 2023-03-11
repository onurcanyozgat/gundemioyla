package com.qpolla.auth.data.dto;

import lombok.Getter;

@Getter
public class UserLoginDto {
    private String username;

    private String email;

    private String password;
}
