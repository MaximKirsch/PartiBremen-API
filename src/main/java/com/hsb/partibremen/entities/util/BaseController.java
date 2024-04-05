package com.hsb.partibremen.entities.util;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class BaseController {

    //Will be @PostMapping
    public BaseEntity create(){
        return null;
    }
    //Will be @GetMapping
    public String findAll(){
        return "200 ok";
    }

    //Will be @GetMapping
    public String findOne(){
        return "200 ok";
    }

    //Will be @PutMapping
    public void update(){

    }

    //Will be @DeleteMapping
    public void delete(){

    }

    @GetMapping("/user/{id}")
    public abstract String findOne(@PathVariable String id);
}
