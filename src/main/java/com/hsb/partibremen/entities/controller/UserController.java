package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.model.user.AutherRequestDto;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.user.UserDto;
import com.hsb.partibremen.entities.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User create(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/user")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> findOne(@PathVariable String id) {
    return userService.findOne(id);
}

    @PutMapping("/user/{id}")
    public Optional<User> update(@RequestBody UserDto userDto, @PathVariable String id) {
        return userService.updateUser(userDto, id);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @PostMapping("/user/login")
    public User login(@RequestBody AutherRequestDto authRequestDto) {
        return userService.login(authRequestDto.getEmail(), authRequestDto.getPassword());
    }
}
