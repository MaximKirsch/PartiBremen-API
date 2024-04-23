package com.hsb.partibremen.entities.controller;

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

    @PostMapping("/user/create")
    public User create(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/user/find-all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/findById")
    public Optional<User> findOne(@RequestParam String id) {
    return userService.findOne(id);
}

    @PutMapping("/user/update")
    public Optional<User> update(@RequestBody UserDto userDto, @RequestParam String id) {
        return userService.updateUser(userDto, id);
    }

    @DeleteMapping("/user/delete")
    public void delete(@RequestParam String id) {
        userService.delete(id);
    }

    @PostMapping("/user/login")
    public User login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }
}
