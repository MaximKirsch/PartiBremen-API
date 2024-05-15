package com.hsb.partibremen.entities.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.model.voting.VotingDto;
import com.hsb.partibremen.entities.service.VotingService;
import com.hsb.partibremen.entities.util.BaseController;

@RestController()
public class VotingController extends BaseController {
    @Autowired
    private VotingService votingService;

    @PostMapping("voting")
    public Voting create(@RequestBody VotingDto votingDto) {
       return votingService.create(votingDto);

    }

    @GetMapping("/voting")
    public List<Voting> findAll() {
        return votingService.findAll();
    }

    @GetMapping("/voting/{id}")
    public Optional<Voting> findOne(@PathVariable String id){
        return votingService.findOne(id);
    }

    @GetMapping("/poi/{poiId}/votings")
    public List<Voting> findPoiVotings(@PathVariable String poiId) {
        return votingService.findPoiVotings(poiId);
    }

    @DeleteMapping("/voting/{id}")
    public void deleteVote(@PathVariable String id){
        votingService.delete(id);
    }
}
