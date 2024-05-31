package com.hsb.partibremen.entities.model.voting;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@SQLDelete(sql = "UPDATE voting SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=0")
public class Voting extends BaseEntity {
    @Column
    private VoteType voteType;
    @ManyToOne
    @JsonBackReference
    private Comment votedComment;
    @ManyToOne
    @JsonBackReference
    private PoI votedPoi;
    @ManyToOne
    @JsonBackReference
    private User voter;

    

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
    public Comment getVotedComment() {
        return votedComment;
    }
    public void setVotedComment(Comment comment) {
        this.votedComment = comment;
    }
    public PoI getVotedPoi() {
        return votedPoi;
    }
    public void setVotedPoi(PoI votedPoi) {
        this.votedPoi = votedPoi;
    }
}
