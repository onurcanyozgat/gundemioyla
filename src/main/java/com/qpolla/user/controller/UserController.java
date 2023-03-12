package com.qpolla.user.controller;

import com.qpolla.auth.data.dto.UserSignupDto;
import com.qpolla.auth.data.dto.error.EmailAlreadyTaken;
import com.qpolla.auth.data.dto.error.UsernameAlreadyTaken;
import com.qpolla.user.data.dto.UserDto;
import com.qpolla.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/update-profile")
    public ResponseEntity<UserDto> updateProfile(@RequestBody UserDto userDto) {
        try {
            UserDto updatedUser = userService.updateProfile(userDto);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
