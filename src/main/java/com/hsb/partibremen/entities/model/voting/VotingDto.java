package com.hsb.partibremen.entities.model.voting;

import java.util.UUID;

import com.hsb.partibremen.entities.enums.VoteType;

public class VotingDto {
    private VoteType voteType;
    private String voterId ;
    private String votedSurveyId;

    public String getVoterId() {
        return voterId;
    }
    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }
    public VoteType getVoteType() {
        return voteType;
    }
    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }
    public String getVotedSurveyId() {
        return votedSurveyId;
    }
    public void setVotedSurveyId(String votedSurveyId) {
        this.votedSurveyId = votedSurveyId;
    }
}
