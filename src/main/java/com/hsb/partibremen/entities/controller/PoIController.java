package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.model.comment.Comment;
import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.poi.PoIDto;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.service.PoIService;
import com.hsb.partibremen.entities.service.UserService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PoIController extends BaseController {
    @Autowired
    private PoIService poIService;
    @Autowired
    private UserService userService;

    @PostMapping("/poi")
    public PoI create(@RequestBody PoIDto poIDto) {
        return poIService.create(poIDto);
    }

    @GetMapping("/poi")
    public List<PoI> findAll() {
        return poIService.findAll();
    }

    @GetMapping("/poi/{id}")
    public Optional<PoI> findOne(@PathVariable String id) {
        return poIService.findOne(id);
    }

    @GetMapping("/poi/{id}/comments")
    public List<Comment> findPoiComments(@PathVariable String id) {
        return poIService.findPoiComments(id);
    }

    @GetMapping("/poi/{id}/votings")
    public List<Voting> findPoiVotings(@PathVariable String id) {
        return poIService.findPoiVotings(id);
    }
    @GetMapping("/poi/Only")
    public List<PoI> findOnlyPoIs() {
        return poIService.findOnlyPoIs();
    }

    @PutMapping("/poi/{id}")
    public Optional<PoI> update(@PathVariable String id, @RequestBody PoIDto poiDto) {
        return poIService.update(id, poiDto);
    }

    @DeleteMapping("/poi/{id}")
    public void delete(@PathVariable String id) {
        poIService.delete(id);
    }
}
