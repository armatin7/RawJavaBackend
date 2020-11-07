package com.armatin.controller;

import com.armatin.dto.UserDto.*;
import com.armatin.model.Role;
import com.armatin.model.User;
import com.armatin.service.RoleService;
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
    private final RoleService roleService;

    @GetMapping(value = "")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getCurrentUser(){
        return new ResponseEntity<>(userService.getCurrentUsername(), HttpStatus.OK);
    }

    @PostMapping(value = "/signing")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        User user = UserMapper.INSTANCE.toEntity(userDto);
        //--------------------------------------
        Role role = new Role();
        role.setRole("ADMIN");
        roleService.createRole(role);
        role = roleService.getRoleByName("ADMIN");
        user.setLinkedRoles(new HashSet<Role>(Arrays.asList(role)));
        //--------------------------------------
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setActive(true);
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
