package com.hsb.partibremen.entities.repo;

import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.survey.Survey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SurveyRepo extends BaseRepo<Survey, UUID> {    
        List<Survey> findByPoi(Optional<PoI> poi);

}
