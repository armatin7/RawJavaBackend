package com.armatin.controller;

import com.armatin.dto.UserDto.*;
import com.armatin.model.User;
import com.armatin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(value = "*")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getCurrentUser(){
        return new ResponseEntity<>(userService.getCurrentUsername(), HttpStatus.OK);
    }

    @PostMapping(value = "/signing")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        User user = new User();//UserMapper.INSTANCE.toEntity(userDto);
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setActive(true);
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
