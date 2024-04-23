package com.hsb.partibremen.entities.model.voting;

import java.util.UUID;

import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.util.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "voting")
public class Voting extends BaseEntity {
    @Column
    private String userId;
    @Column
    private VoteType voteType;
    @Column
    private String surveyId;
    

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
