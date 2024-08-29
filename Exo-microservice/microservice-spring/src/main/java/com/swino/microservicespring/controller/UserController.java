package com.swino.microservicespring.controller;

import com.swino.microservicespring.dto.UserDto;
import com.swino.microservicespring.entity.UserEntity;
import com.swino.microservicespring.mapper.UserMapper;
import com.swino.microservicespring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        UserEntity userEntity = userMapper.userDtoToUserEntity(userDto);
        UserEntity createdUser = userService.createUser(userEntity);
        return userMapper.userEntityToUserDto(createdUser);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(userMapper::userEntityToUserDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(userMapper::userEntityToUserDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto updatedUserDto) {
        try {
            UserEntity updatedUserEntity = userMapper.userDtoToUserEntity(updatedUserDto);
            UserEntity updatedUser = userService.updateUser(id, updatedUserEntity);
            return ResponseEntity.ok(userMapper.userEntityToUserDto(updatedUser));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}