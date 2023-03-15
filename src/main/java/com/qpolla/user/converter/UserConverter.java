package com.qpolla.user.converter;

import com.qpolla.role.converter.RoleConverter;
import com.qpolla.role.data.dto.RoleDto;
import com.qpolla.role.data.entity.RoleEntity;
import com.qpolla.user.data.dto.UserDto;
import com.qpolla.user.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    private final RoleConverter roleConverter;

    @Autowired
    public UserConverter(RoleConverter roleConverter) {
        this.roleConverter = roleConverter;
    }

    public UserDto toDto(UserEntity source) {
        if (source == null) {
            return null;
        }
        UserDto target = new UserDto();
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setEmail(source.getEmail());
        // target.setPassword(source.getPassword());
        target.setIp(source.getIp());
        target.setAvatar(source.getAvatar());
        target.setBanBeginDate(source.getBanBeginDate());
        target.setBanEndDate(source.getBanEndDate());
        target.setLastLoginDate(source.getLastLoginDate());
        target.setPollCounter(source.getPollCounter());
        target.setRegisteredDate(source.getRegisteredDate());
        target.setUrl(source.getUrl());
        target.setStatus(source.getStatus());
        List<RoleDto> roleList = source.getRoles().stream().map(e -> roleConverter.toDto(e)).collect(Collectors.toList());
        target.setRoles(roleList);
        return target;
    }

    public UserEntity toEntity(UserDto source) {
        if (source == null) {
            return null;
        }
        UserEntity target = new UserEntity();
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setEmail(source.getEmail());
        // target.setPassword(source.getPassword());
        target.setIp(source.getIp());
        target.setAvatar(source.getAvatar());
        target.setBanBeginDate(source.getBanBeginDate());
        target.setBanEndDate(source.getBanEndDate());
        target.setLastLoginDate(source.getLastLoginDate());
        target.setPollCounter(source.getPollCounter());
        target.setRegisteredDate(source.getRegisteredDate());
        target.setUrl(source.getUrl());
        target.setStatus(source.getStatus());
        List<RoleEntity> roleList = source.getRoles().stream().map(e -> roleConverter.toEntity(e)).collect(Collectors.toList());
        target.setRoles(roleList);
        return target;
    }
}
