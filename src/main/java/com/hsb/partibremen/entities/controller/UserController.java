package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.user.UserDto;
import com.hsb.partibremen.entities.service.UserService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
public class UserController extends BaseController {
    @Autowired
    public UserService userService;
    @PostMapping("user")
    public User create(@RequestBody UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setDob(userDto.getDob());
        user.setVerified(userDto.isVerified());
        this.userService.createUser(user);
        return user;
    }

    @GetMapping("/user")
    public List<User> findAll() {
       return this.userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> findOne(@PathVariable String id){
        return this.userService.findOne(id);
    }

    @GetMapping("/user/login/{emailAdress}/{password}")
    public User login(@PathVariable String emailAdress, @PathVariable String password) {
        return this.userService.login(emailAdress, password);
    }


    @PutMapping("/user/{id}")
    public Optional<User> update(@PathVariable String id, @RequestBody UserDto userDto) {
       return userService.findOne(id);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }
}
