package com.hsb.partibremen.entities.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hsb.partibremen.entities.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.model.voting.VotingDto;
import com.hsb.partibremen.entities.service.VotingService;
import com.hsb.partibremen.entities.util.BaseController;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.server.ResponseStatusException;


@RestController()
public class VotingController extends BaseController {
    @Autowired
    private VotingService votingService;

    @PostMapping("voting")
    public Voting create(@RequestBody VotingDto votingDto) throws UserNotFoundException, SurveyNotFoundException, PoINotFoundException, CommentNotFoundException {
       return votingService.create(votingDto);

    }

    @GetMapping("/voting")
    public List<Voting> findAll() {
        return votingService.findAll();
    }

    @GetMapping("/voting/{id}")
    public Optional<Voting> findOne(@PathVariable String id) {
        try{
            return votingService.findOne(id);
        } catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Vote not found", ex);
        }

    }

    @GetMapping("/voting/{poiId}/fromPoI")
    public List<Voting> findPoiVotings(@PathVariable String poiId) {
        return votingService.findPoiVotings(poiId);
    }

    @DeleteMapping("/voting/{id}")
    public void deleteVote(@PathVariable String id){
        votingService.delete(id);
    }
}
