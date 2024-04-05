package com.hsb.partibremen.controller;

import com.hsb.partibremen.util.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
public class UserController extends BaseController {

    @GetMapping("/")
    @Override
    public void findAll() {
        super.findAll();
    }
}
