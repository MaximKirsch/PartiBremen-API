package com.hsb.partibremen.entities.repo;

import com.hsb.partibremen.entities.model.report.Report;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VotingRepo extends BaseRepo<Report, UUID> {
    

}


