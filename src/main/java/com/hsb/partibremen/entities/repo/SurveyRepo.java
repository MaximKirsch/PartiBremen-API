package com.hsb.partibremen.entities.repo;

import com.hsb.partibremen.entities.model.survey.Survey;
import com.hsb.partibremen.entities.model.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface SurveyRepo extends BaseRepo<Survey, UUID> {    

}
