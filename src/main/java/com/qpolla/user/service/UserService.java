package com.qpolla.user.service;

import com.qpolla.auth.data.dto.UserSignupDto;
import com.qpolla.user.data.EnumUserStatus;
import com.qpolla.user.data.dto.UserChangeRequestDto;
import com.qpolla.user.data.dto.UserDto;
import com.qpolla.user.data.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto saveUser(UserDto user);

    UserDto updateProfile(UserDto user);

    UserDto updateStatus(UserChangeRequestDto userChangeRequest);

    UserEntity findUserById(Long id);
}
