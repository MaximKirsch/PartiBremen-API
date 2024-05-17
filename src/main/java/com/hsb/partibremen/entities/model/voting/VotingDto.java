package com.hsb.partibremen.entities.model.voting;

import com.hsb.partibremen.entities.enums.VoteType;

public class VotingDto {
    private VoteType voteType;
    private String voterId;
    private String poiId;
    private String commentId;

    //TODO: Add the posibility to vote for a comment and the other things that are defined at Voting.java

    public String getPoiId() {
        return poiId;
    }
    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }
    public String getCommentId() {
        return commentId;
    }
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
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

}
