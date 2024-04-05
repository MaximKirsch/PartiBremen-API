package com.hsb.partibremen.controller;

import com.hsb.partibremen.model.User;
import com.hsb.partibremen.model.UserDto;
import com.hsb.partibremen.util.BaseController;
import org.springframework.web.bind.annotation.*;

@RestController()
public class UserController extends BaseController {

    @PostMapping("user")
    public User create(@RequestBody UserDto userDto){
        User user = new User();
        // user.blabla = userDto.blabla
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
