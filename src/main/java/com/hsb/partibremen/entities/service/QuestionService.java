package com.hsb.partibremen.entities.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hsb.partibremen.entities.model.question.Question;
import com.hsb.partibremen.entities.model.question.QuestionDto;
import com.hsb.partibremen.entities.repo.QuestionRepo;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends BaseService {
    @Autowired
    public QuestionRepo questionRepo;
    @Autowired
    private SurveyService surveyService;

    public Question create(QuestionDto questionDto) {
        Question question = new Question();
        question.setFragestellung(questionDto.getFragestellung());
        question.setType(questionDto.getType());

        if(!(this.surveyService.findOne(questionDto.getSurveyId())).isPresent()){
            throw new RuntimeException();
        }
        question.setSurvey((this.surveyService.findOne(questionDto.getSurveyId())).get());

        return this.questionRepo.save(question);
    }
    public List<Question> findAll(){
        return this.questionRepo.findAll();
    }
    public Optional<Question> findOne(String id) {
        return questionRepo.findById(UUID.fromString(id));
    }

    public void delete(String id) {
        questionRepo.deleteById(UUID.fromString(id));
    }

}
