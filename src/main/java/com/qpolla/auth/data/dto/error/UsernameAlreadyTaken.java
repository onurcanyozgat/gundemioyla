package com.qpolla.auth.data.dto.error;

public class UsernameAlreadyTaken extends Error{
    public UsernameAlreadyTaken(String message) {
        super(message);
    }
}
