package com.hsb.partibremen.entities.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hsb.partibremen.entities.exceptions.SurveyNotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.exceptions.VotingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hsb.partibremen.entities.enums.VoteType;
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
    public Voting create(@RequestBody VotingDto votingDto) throws UserNotFoundException, SurveyNotFoundException {
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

    @DeleteMapping("/voting/{id}")
    public void deleteVote(@PathVariable String id){
        votingService.delete(id);
    }
}
