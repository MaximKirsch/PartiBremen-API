package com.hsb.partibremen.entities.repo;

import com.hsb.partibremen.entities.model.question.Question;
import com.hsb.partibremen.entities.model.survey.Survey;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionRepo extends BaseRepo<Question, UUID> {
    
    List<Question> findBySurvey(Optional<Survey> survey);
}


