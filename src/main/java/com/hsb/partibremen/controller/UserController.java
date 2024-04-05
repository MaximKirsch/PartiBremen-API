package com.hsb.partibremen.controller;

import com.hsb.partibremen.util.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController()
public class UserController extends BaseController {

    @GetMapping("/")
    @Override
    public String findAll() {
       return super.findAll();
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable String id){
        return super.findOne();
    }
}
