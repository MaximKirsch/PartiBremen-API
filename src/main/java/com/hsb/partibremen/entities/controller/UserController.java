package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.user.UserDto;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.web.bind.annotation.*;

@RestController()
public class UserController extends BaseController {

    @PostMapping("user")
    public User create(@RequestBody UserDto userDto){
        User user = new User();
        user.name = userDto.name;
        user.password = userDto.password;
        return user;
    }

    @GetMapping("/user")
    @Override
    public String findAll() {
       return super.findAll();
    }

    @GetMapping("/user/{id}")
    @Override
    public String findOne(@PathVariable String id){
        return super.findOne();
    }
}
