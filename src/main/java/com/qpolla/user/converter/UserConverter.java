package com.qpolla.user.converter;

import com.qpolla.user.data.dto.UserDto;
import com.qpolla.user.data.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDto toDto(UserEntity source) {
        UserDto target = new UserDto();
        return target;
    }

    public UserEntity toEntity(UserDto source) {
        UserEntity target = new UserEntity();
        return target;
    }
}
