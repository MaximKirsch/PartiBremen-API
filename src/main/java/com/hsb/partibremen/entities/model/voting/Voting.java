package com.hsb.partibremen.entities.model.voting;

import java.util.UUID;

import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.util.BaseEntity;

public class Voting extends BaseEntity {
    //@Collumn
    private String userId;
    //@Collumn
    private VoteType voteType;
    //@Collumn
    private String surveyId;
    
    public Voting(String userId, VoteType voteType, String surveyId) {
        this.userId = userId;
        this.voteType = voteType;
        this.surveyId = surveyId;
    }
    public Voting(){
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    

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
}
