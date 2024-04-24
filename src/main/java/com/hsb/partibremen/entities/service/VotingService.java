package com.hsb.partibremen.entities.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.model.servey.Survey;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.model.voting.VotingDto;
import com.hsb.partibremen.entities.repo.VotingRepo;
import com.hsb.partibremen.entities.util.BaseService;

@Service
public class VotingService extends BaseService {
    @Autowired
    private VotingRepo votingRepo;
    @Autowired
    private SurveyService surveyService;
    @Autowired
    private UserService userService;

    public Voting create(VotingDto votingDto) {
        Voting voting = new Voting();
        voting.setVoteType(votingDto.getVoteType());

        if(!this.userService.findOne(votingDto.getVoterId()).isPresent()){
            throw new RuntimeException();
        }
        voting.setVoter(this.userService.findOne(votingDto.getVoterId()).get());

        if(!this.surveyService.findOne(votingDto.getVotedSurveyId()).isPresent()){
            throw new RuntimeException();
        }
        voting.setVotedSurvey(this.surveyService.findOne(votingDto.getVotedSurveyId()).get());

        return votingRepo.save(voting);
    }

    public List<Voting> findAll() {
        return this.votingRepo.findAll();
    }

    public Optional<Voting> findOne(String id) {
        return this.votingRepo.findById(UUID.fromString(id));
    }

    public void delete(String id){
        this.votingRepo.deleteById(UUID.fromString(id));
    }
}
