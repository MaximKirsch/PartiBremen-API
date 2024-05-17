package com.hsb.partibremen.entities.service;

import java.util.List;
import java.util.UUID;
import com.hsb.partibremen.entities.exceptions.SurveyNotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.exceptions.VotingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.model.voting.VotingDto;
import com.hsb.partibremen.entities.repo.VotingRepo;
import com.hsb.partibremen.entities.util.BaseService;

@Service
public class VotingService extends BaseService {
    @Autowired
    public VotingRepo votingRepo;
    @Autowired
    private UserService userService;
    @Autowired
    public PoIService poIService;
    @Autowired
    public CommentService commentService;

    public Voting create(VotingDto votingDto) throws UserNotFoundException, SurveyNotFoundException {
        Voting voting = new Voting();
        voting.setVoteType(votingDto.getVoteType());

        if(!this.userService.findOne(votingDto.getVoterId()).isPresent()){
            throw new RuntimeException();
        }
        voting.setVoter(this.userService.findOne(votingDto.getVoterId()).get());

        if (votingDto.getPoiId() != null && votingDto.getCommentId() != null){
            throw new RuntimeException();
        }

        if(votingDto.getPoiId() != null){
            voting.setVotedPoi(this.poIService.findOne(votingDto.getPoiId() != null ? votingDto.getPoiId() : "").get());        
        }
        if(votingDto.getCommentId() != null){
            voting.setVotedComment(this.commentService.findOne(votingDto.getCommentId() != null ? votingDto.getCommentId() : "").get());        
        }
        return votingRepo.save(voting);
    }

    public List<Voting> findAll() {
        return this.votingRepo.findAll();
    }

    public Optional<Voting> findOne(String id) throws VotingNotFoundException {
        if(this.votingRepo.findById(UUID.fromString(id)) != null){
            return this.votingRepo.findById(UUID.fromString(id));
        }
        throw new VotingNotFoundException();
    }

    public void delete(String id){
        this.votingRepo.deleteById(UUID.fromString(id));
    }

    public List<Voting> findPoiVotings(String poiId) {
        return this.votingRepo.findAllByVotedPoi_id(UUID.fromString(poiId));
    }
}
