package com.hsb.partibremen.entities.model.voting;

import java.util.UUID;

import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.util.BaseEntity;

public class Voting extends BaseEntity {
    private UUID userId;
    private VoteType voteType;

    
    public Voting(UUID userId, VoteType voteType) {
        this.userId = userId;
        this.voteType = voteType;
    }

    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public VoteType getVoteType() {
        return voteType;
    }
    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }
}
