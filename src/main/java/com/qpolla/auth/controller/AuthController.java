package com.qpolla.auth.controller;

import com.qpolla.auth.data.dto.UserLoginDto;
import com.qpolla.auth.data.dto.UserResponseDto;
import com.qpolla.auth.data.dto.UserSignupDto;
import com.qpolla.auth.data.dto.error.EmailAlreadyTaken;
import com.qpolla.auth.data.dto.error.UsernameAlreadyTaken;
import com.qpolla.auth.service.AuthService;
import com.qpolla.user.data.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RequestMapping("api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> authenticate(@RequestBody UserLoginDto userLoginDto) {
        try {
            return ResponseEntity.ok(authService.authenticate(userLoginDto));
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/changePassword")
    public ResponseEntity<Void> changePassword(@RequestBody UserLoginDto changePasswordRequest) {
        try {
            if (authService.changePassword(changePasswordRequest)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.internalServerError().build();
            }
        } catch (UsernameNotFoundException ex) {
            log.warn("Username is not found while changing password.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserSignupDto userSignupDto) {
        try {
            UserDto userDto = authService.registerUser(userSignupDto);
            return ResponseEntity.ok(userDto);
        } catch (EmailAlreadyTaken ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (UsernameAlreadyTaken ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
