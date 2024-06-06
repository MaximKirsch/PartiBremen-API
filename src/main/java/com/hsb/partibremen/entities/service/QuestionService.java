package com.hsb.partibremen.entities.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hsb.partibremen.entities.exceptions.QuestionNotFoundException;
import com.hsb.partibremen.entities.exceptions.SurveyNotFoundException;
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

    public Question create(QuestionDto questionDto) throws SurveyNotFoundException {
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
    public Optional<Question> findOne(String id) throws QuestionNotFoundException {
        if(questionRepo.findById(UUID.fromString(id)).isPresent()){
            return questionRepo.findById(UUID.fromString(id));
        }
        throw new QuestionNotFoundException("No Question found");
    }

    public void delete(String id) {
        questionRepo.deleteById(UUID.fromString(id));
    }

    public List<Question> getQuestionsFromSurvey(String id){
        
        UUID surveyUUID = UUID.fromString(id);
        List<Question> questions = questionRepo.findBySurveyId(surveyUUID);
        
        return questions;
    }

}
