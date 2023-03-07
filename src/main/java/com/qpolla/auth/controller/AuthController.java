package com.qpolla.auth.controller;

import com.qpolla.auth.data.dto.UserLoginDto;
import com.qpolla.auth.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public ResponseEntity<UserLoginDto> authenticate(@Valid @RequestBody UserLoginDto userLoginDto) {
        try {
            return ResponseEntity.ok(authService.authenticate(userLoginDto));
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/changePassword")
    public ResponseEntity<Void> changePassword(@Valid @RequestBody UserLoginDto changePasswordRequest) {
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
}
