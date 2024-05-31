package com.hsb.partibremen.entities.service;

import java.util.List;
import java.util.UUID;

import com.hsb.partibremen.entities.exceptions.*;
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

    public Voting create(VotingDto votingDto) throws UserNotFoundException, SurveyNotFoundException, PoINotFoundException, CommentNotFoundException, VoteAlreadyExistsException {
        // Überprüfen, ob der Benutzer existiert
        if (!this.userService.findOne(votingDto.getVoterId()).isPresent()) {
            throw new UserNotFoundException("User not found");
        }

        UUID voterId = UUID.fromString(votingDto.getVoterId());
        UUID poiId = votingDto.getPoiId() != null ? UUID.fromString(votingDto.getPoiId()) : null;
        UUID commentId = votingDto.getCommentId() != null ? UUID.fromString(votingDto.getCommentId()) : null;

        // Überprüfen, ob bereits ein Vote existiert
        Optional<Voting> existingVote = Optional.empty();
        if (poiId != null) {
            existingVote = votingRepo.findByVoter_IdAndVotedPoi_Id(voterId, poiId);
        } else if (commentId != null) {
            existingVote = votingRepo.findByVoter_IdAndVotedComment_Id(voterId, commentId);
        }

        if (existingVote.isPresent()) {
            Voting vote = existingVote.get();
            // Wenn der existierende Vote den gleichen Typ hat, werfen wir eine Ausnahme
            if (vote.getVoteType() == votingDto.getVoteType()) {
                throw new VoteAlreadyExistsException("Vote of the same type already exists");
            } else {
                // Wenn der Vote-Typ unterschiedlich ist, aktualisieren wir ihn
                vote.setVoteType(votingDto.getVoteType());
                return votingRepo.save(vote);
            }
        }

        // Wenn kein existierender Vote gefunden wurde, erstellen wir einen neuen
        Voting voting = new Voting();
        voting.setVoteType(votingDto.getVoteType());
        voting.setVoter(this.userService.findOne(votingDto.getVoterId()).get());

        if (poiId != null) {
            voting.setVotedPoi(this.poIService.findOne(votingDto.getPoiId()).get());
        }
        if (commentId != null) {
            voting.setVotedComment(this.commentService.findOne(votingDto.getCommentId()).get());
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
