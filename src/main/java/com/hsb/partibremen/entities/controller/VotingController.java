package com.hsb.partibremen.entities.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public VotingService VotingService = new VotingService();

    @PostMapping("voting")
    public Voting create(@RequestBody VotingDto votingDto) {
        Voting voting = new Voting();

        voting.setSurveyId(votingDto.getSurveyId());
        voting.setUserId(votingDto.getUserId());
        voting.setVoteType(votingDto.getVoteType());

        VotingService.votingList.add(voting);
        return voting;

    }

    @Operation(summary = "Set a Vote for the survey", description = "Adds a vote object to survey with given userid, if vote already exists it updates the vote if it changes")
    @PostMapping("/voting/{surveyid}/bewerten{type}/{userid}")
    public void bewerten(@PathVariable String surveyid, @PathVariable VoteType type, @PathVariable String userid) {
        this.VotingService.bewerten(surveyid, type, userid);
    }
    
    @Operation(summary = "Gives the vote Count", description = "It gives only an int with the count for the given Votetype")
    @GetMapping("/voting/{surveyId}/count/{type}")
    public int countVotes(@PathVariable String surveyId, @PathVariable VoteType type) {
        return this.VotingService.countVotes(surveyId, type);
    }

    @DeleteMapping("/voting/{surveyId}/{userId}")
    public void deleteVote(@PathVariable String surveyId, @PathVariable String userId){
        this.VotingService.deleteVote(surveyId, userId);
    }


}
