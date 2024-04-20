package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.user.UserDto;
import com.hsb.partibremen.entities.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User create(@RequestBody UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setDob(userDto.getDob());
        user.setVerified(userDto.isVerified());
        userService.createUser(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> findOne(@RequestParam String id) {
        return userService.findOne(id);
    }

    @PostMapping("/user/login")
    public User login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    @PutMapping("/user/{id}")
    public Optional<User> update(@RequestParam String id, @RequestBody UserDto userDto) {
        return userService.findOne(id);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@RequestParam String id) {
        userService.delete(id);
    }
}
