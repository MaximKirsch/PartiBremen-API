package com.hsb.partibremen.entities.repo;

import com.hsb.partibremen.entities.model.report.Report;
import com.hsb.partibremen.entities.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportRepo extends BaseRepo<Report, UUID> {
    

}


