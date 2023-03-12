package com.qpolla.auth.service;

import com.qpolla.auth.data.dto.UserResponseDto;
import com.qpolla.auth.data.dto.UserLoginDto;
import com.qpolla.auth.data.dto.UserSignupDto;
import com.qpolla.auth.data.dto.error.EmailAlreadyTaken;
import com.qpolla.auth.data.dto.error.UsernameAlreadyTaken;
import com.qpolla.user.data.dto.UserDto;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthService {
    UserResponseDto authenticate(UserLoginDto userLoginDto) throws UsernameNotFoundException;

    UserDto registerUser(UserSignupDto signupDto) throws EmailAlreadyTaken, UsernameAlreadyTaken;

    Boolean changePassword(UserLoginDto userLoginDto) throws UsernameNotFoundException;
}
