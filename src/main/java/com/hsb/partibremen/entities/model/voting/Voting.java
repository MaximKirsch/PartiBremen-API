package com.hsb.partibremen.entities.model.voting;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.model.comment.Comment;
import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.survey.Survey;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.util.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "voting")
public class Voting extends BaseEntity {
    @Column
    private VoteType voteType;
    @ManyToOne
    @JsonBackReference
    private Survey votedSurvey;
    @ManyToOne
    @JsonBackReference
    private Comment votedComment;
    @ManyToOne
    @JsonBackReference
    private PoI votedPoi;
    @ManyToOne
    @JsonBackReference
    private User voter;

    

    public Survey getVotedSurvey() {
        return votedSurvey;
    }

    public void setVotedSurvey(Survey votedSurvey) {
        this.votedSurvey = votedSurvey;
    }

    public User getVoter() {
        return voter;
    }
    public void setVoter(User voter) {
        this.voter = voter;
    }
    public VoteType getVoteType() {
        return voteType;
    }
    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }
}
