package com.project.webcrud.controller;

import com.project.webcrud.dto.PlainUserDto;
import com.project.webcrud.dto.UserDto;
import com.project.webcrud.entity.UserEntity;
import com.project.webcrud.mapper.PlainUserMapper;
import com.project.webcrud.mapper.UserMapper;
import com.project.webcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PlainUserMapper plainUserMapper;

    @PostMapping(value = "/user")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userMapper.toDto(userService.saveUser(userDto));
    }

    @GetMapping(value = "/user/{userId}")
    public UserDto getUserById(@PathVariable(value = "userId") Long userId) {
        return userMapper.toDto(userService.getUserById(userId));
    }

    @GetMapping(value = "/users")
    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return users.stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @PutMapping(value = "/user/{userId}")
    public UserDto updateUserById(@RequestBody UserDto userDto,
                                  @PathVariable(value = "userId") Long userId) {
        return userMapper.toDto(userService.updateUserById(userDto, userId));
    }

    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable(value = "userId") Long userId) {
        return userService.deleteUserById(userId);
    }

    @PostMapping(value = "/user/{userId}/book/{bookId}")
    public PlainUserDto addBookToUser(@PathVariable(value = "userId") Long userId,
                                      @PathVariable(value = "bookId") Long bookId) {
        return plainUserMapper.toPlainDto(userService.addBookToUser(userId, bookId));
    }

    @DeleteMapping(value = "/user/{userId}/book/{bookId}")
    public UserDto removeBookFromUser(@PathVariable(value = "userId") Long userId,
                                 @PathVariable(value = "bookId") Long bookId) {
        return userMapper.toDto(userService.removeBookFromUser(userId, bookId));
    }
}
