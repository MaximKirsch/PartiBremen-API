package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.poi.PoIDto;
import com.hsb.partibremen.entities.service.PoIService;
import com.hsb.partibremen.entities.service.UserService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PoIController extends BaseController {
    @Autowired
    private PoIService poIService;
    @Autowired
    private UserService userService;

    @PostMapping("/poi")
    public PoI create(@RequestBody PoIDto poIDto) throws UserNotFoundException {
        return poIService.create(poIDto);
    }

    @GetMapping("/poi")
    public List<PoI> findAll() {
        return poIService.findAll();
    }

    @GetMapping("/poi/{id}")
    public Optional<PoI> findOne(@PathVariable String id) {
        try{
            return poIService.findOne(id);
        } catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Point of Interest Not Found", ex);
        }

    }
    @GetMapping("/poi/Only")
    public List<PoI> findOnlyPoIs() {
        return poIService.findOnlyPoIs();
    }

    @PutMapping("/poi/{id}")
    public Optional<PoI> update(@PathVariable String id, @RequestBody PoIDto poiDto) throws UserNotFoundException {
        try {
            return poIService.update(id, poiDto);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", ex);
        }
    }
    @DeleteMapping("/poi/{id}")
    public void delete(@PathVariable String id) {
        poIService.delete(id);
    }

    @GetMapping("/poi/user/{userId}")
    public List<PoI> findByUserId(@PathVariable String userId) {
        try {
            return poIService.findByUserId(userId);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User Not Found", ex);
        }
    }
}
