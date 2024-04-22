package com.hsb.partibremen.entities.service;

import java.util.ArrayList;
import java.util.UUID;

import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.model.servey.Survey;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.util.BaseService;

public class VotingService extends BaseService {
    public ArrayList<Voting> votingList = new ArrayList<>();

    public SurveyService SurveyService = new SurveyService();
    public void bewerten(String surveyId, VoteType type, String userId) {
        Survey servey = SurveyService.findOne(surveyId);
        if (servey != null) {
            Voting existingVote = findVote(surveyId, userId);
            if (existingVote == null)
                votingList.add(new Voting(userId, type, userId));
            else if( existingVote.getVoteType() != type){
                existingVote.setVoteType(type);
                deleteVote(surveyId, userId);
                votingList.add(existingVote);
            }
        }
    }

    public void deleteVote(String surveyID, String userId){
        Voting voteToDelete = findVote(surveyID, userId);
        if(voteToDelete != null){
            votingList.remove(voteToDelete);
        }
    }

    public Voting findVote(String surveyId, String userId) {
        for (Voting vote : votingList) {
            if (vote.getUserId().equals(userId) && vote.getSurveyId().equals(surveyId)) {
                return vote;
            }
        }
        return null;
    }

    public int countVotes(String surveyId, VoteType type){
        Survey servey = SurveyService.findOne(surveyId);
        if(servey == null) return 0;
        else {
            int count = 0;
            for(Voting vote : votingList){
                if(vote.getVoteType() == type && vote.getSurveyId().equals(surveyId)){
                    count++;
                }
            
            }
            return count;
        }
    }


}
