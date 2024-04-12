package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.user.UserDto;
import com.hsb.partibremen.entities.service.UserService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController()
public class UserController extends BaseController {
    public UserService userService = new UserService();
    @PostMapping("user")
    public User create(@RequestBody UserDto userDto){
        User user = new User();
        user.name = userDto.name;
        user.password = userDto.password;
        userService.userList.add(user);
        return user;
    }

    @GetMapping("/user")
    public ArrayList<User> findAll() {
       return this.userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findOne(@PathVariable String id){
        return this.userService.findOne(id);
    }
}
