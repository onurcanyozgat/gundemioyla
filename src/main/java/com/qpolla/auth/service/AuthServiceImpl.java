package com.qpolla.auth.service;

import com.qpolla.auth.data.dto.MessageResponse;
import com.qpolla.auth.data.dto.UserResponseDto;
import com.qpolla.auth.data.dto.UserLoginDto;
import com.qpolla.auth.data.dto.UserSignupDto;
import com.qpolla.auth.data.dto.error.EmailAlreadyTaken;
import com.qpolla.auth.data.dto.error.UsernameAlreadyTaken;
import com.qpolla.auth.service.jwt.JwtUtils;
import com.qpolla.user.data.dto.UserDto;
import com.qpolla.user.data.entity.UserEntity;
import com.qpolla.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    @Autowired
    public AuthServiceImpl(UserService userService, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public UserResponseDto authenticate(UserLoginDto loginDto) throws UsernameNotFoundException {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserEntity userDetails = (UserEntity) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        return new UserResponseDto(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);
    }

    @Override
    public UserDto registerUser(UserSignupDto signupDto) throws EmailAlreadyTaken, UsernameAlreadyTaken {
        return userService.saveUser(new UserDto(signupDto.getUsername(), signupDto.getEmail(), signupDto.getPassword()));
    }

    @Override
    public Boolean changePassword(UserLoginDto userLoginDto) {
        return null;
    }
}
