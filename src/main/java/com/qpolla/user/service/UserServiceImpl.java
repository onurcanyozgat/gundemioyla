package com.qpolla.user.service;

import com.qpolla.auth.data.dto.error.EmailAlreadyTaken;
import com.qpolla.auth.data.dto.error.UsernameAlreadyTaken;
import com.qpolla.exception.ResourceNotFoundException;
import com.qpolla.role.data.entity.RoleEntity;
import com.qpolla.role.sevice.RoleService;
import com.qpolla.user.converter.UserConverter;
import com.qpolla.user.data.dto.UserChangeRequestDto;
import com.qpolla.user.data.dto.UserDto;
import com.qpolla.user.data.entity.UserEntity;
import com.qpolla.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserConverter userConverter;

    private final RoleService roleService;

     private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto saveUser(UserDto userDto) throws UsernameAlreadyTaken, EmailAlreadyTaken {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new UsernameAlreadyTaken("Error: Username is already taken!");
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UsernameAlreadyTaken("Error: Email is already taken!");
        }
         UserEntity user = new UserEntity(userDto.getUsername(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        UserEntity savedEntity = userRepository.save(user);
        return userConverter.toDto(savedEntity);
    }

    @Override
    public UserDto updateProfile(UserDto userDto) {
        UserEntity userEntity = userConverter.toEntity(userDto);
        UserEntity savedEntity = userRepository.save(userEntity);
        return userConverter.toDto(savedEntity);
    }

    @Override
    public UserDto updateStatus(UserChangeRequestDto userChangeRequest) {
        Optional<UserEntity> entity = userRepository.findByUsername(userChangeRequest.getUsername());
        UserEntity user = entity.orElseThrow(() -> new ResourceNotFoundException("User is not found with the given username:", userChangeRequest.getUsername()));
        user.setStatus(userChangeRequest.getNewStatus());
        userRepository.save(user);
        return userConverter.toDto(user);
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userRepository.findById(id).orElseGet(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).get();
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleEntity> roles) {
        Collection<? extends GrantedAuthority> mapRoles =
                roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole().name())).collect(Collectors.toList());
        return mapRoles;
    }
}
