package com.hsb.partibremen.entities.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.model.voting.VotingDto;
import com.hsb.partibremen.entities.service.VotingService;
import com.hsb.partibremen.entities.util.BaseController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController()

public class VotingController extends BaseController {
    @Autowired
    private VotingService votingService;

    @PostMapping("voting/create")
    public Voting create(@RequestBody VotingDto votingDto) {
        //Er setzt nicht die Werte für Voting warum auch immer, bin da noch nicht auf den Fehler gestoßen
       return votingService.createVoting(votingDto);

    }

    @Operation(summary = "Set a Vote for the survey", description = "Adds a vote object to survey with given userid, if vote already exists it updates the vote if it changes")
    @PostMapping("/voting/bewerten")
    public void bewerten(@RequestParam String surveyid, @RequestParam VoteType type, @RequestParam String userid) {
        votingService.bewerten(surveyid, type, userid);
    }
    
    @Operation(summary = "Gives the vote Count", description = "It gives only an int with the count for the given Votetype")
    @GetMapping("/voting/count")
    public int countVotes(@RequestParam String surveyId, @RequestParam VoteType type) {
        return votingService.countVotes(surveyId, type);
    }

    @DeleteMapping("/voting")
    public void deleteVote(@RequestParam String surveyId, @RequestParam String userId){
        votingService.deleteVote(surveyId, userId);
    }
}
