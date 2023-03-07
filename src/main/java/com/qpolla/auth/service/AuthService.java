package com.qpolla.auth.service;

import com.qpolla.auth.data.dto.UserLoginDto;
import com.qpolla.auth.data.dto.UserSignupDto;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthService {
    UserLoginDto authenticate(UserLoginDto userLoginDto) throws UsernameNotFoundException;

    UserSignupDto signup(UserSignupDto userSignupDto);

    Boolean changePassword(UserLoginDto userLoginDto) throws UsernameNotFoundException;
}
