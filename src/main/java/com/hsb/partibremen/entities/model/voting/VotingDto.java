package com.hsb.partibremen.entities.model.voting;

import java.util.UUID;

import com.hsb.partibremen.entities.enums.VoteType;

public class VotingDto {

    private String userId ;
    private VoteType voteType;
    private String surveyId;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public VoteType getVoteType() {
        return voteType;
    }
    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }
    public String getSurveyId() {
        return surveyId;
    }
    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }
}
