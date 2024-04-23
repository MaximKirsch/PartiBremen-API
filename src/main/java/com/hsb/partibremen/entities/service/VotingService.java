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

    public Voting createVoting(VotingDto votingDto) {
        Voting voting = new Voting();
        voting.setSurveyId(votingDto.getSurveyId());
        voting.setUserId(votingDto.getUserId());
        voting.setVoteType(votingDto.getVoteType());
        System.out.println("SurveyID: "+votingDto.getSurveyId());
        System.out.println("userID: "+votingDto.getUserId());
        System.out.println("voteType: "+votingDto.getVoteType());
        return votingRepo.save(voting);
    }

    public void bewerten(String surveyId, VoteType type, String userId) {
        Optional<Voting> existingVote = findVote(surveyId, userId);
        if (existingVote.isPresent() && existingVote.get().getVoteType() != type) {
            Voting vote = existingVote.get();
            vote.setVoteType(type);
            votingRepo.save(vote);
        }else{
            Voting voting = new Voting();
            voting.setSurveyId(surveyId);
            voting.setUserId(userId);
            voting.setVoteType(type);
            System.out.println("SurveyID: "+surveyId);
            System.out.println("userID: "+userId);
            System.out.println("voteType: "+type);
            votingRepo.save(voting);
        }
    }

    public void deleteVote(String surveyID, String userId){
        Voting optVote = findVote(surveyID, userId).orElse(null);
        if(optVote != null){
            votingRepo.delete(optVote);
        }
    }

    public Optional<Voting> findVote(String surveyId, String userId) {
        return votingRepo.findBySurveyIdAndUserId(surveyId,userId);
    }

    public int countVotes(String surveyId, VoteType type){
        List<Voting> list = votingRepo.findAllBySurveyIdAndVoteType(surveyId, type);
        return list.size();
    }   
}
