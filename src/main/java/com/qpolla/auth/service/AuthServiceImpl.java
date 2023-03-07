package com.qpolla.auth.service;

import com.qpolla.auth.data.dto.UserLoginDto;
import com.qpolla.auth.data.dto.UserSignupDto;
import com.qpolla.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    @Autowired
    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserLoginDto authenticate(UserLoginDto userLoginDto) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserSignupDto signup(UserSignupDto userSignupDto) {
        return null;
    }

    @Override
    public Boolean changePassword(UserLoginDto userLoginDto) {
        return null;
    }
}
