package com.hsb.partibremen.entities.repo;

import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.voting.Voting;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VotingRepo extends BaseRepo<Voting, UUID> { 
    Optional<Voting> findBySurveyIdAndUserId(String surveyId, String userId);
    List<Voting> findAllBySurveyIdAndVoteType(String surveyId, VoteType type);
}
