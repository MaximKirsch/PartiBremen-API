package com.hsb.partibremen.entities.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hsb.partibremen.entities.exceptions.PoINotFoundException;
import com.hsb.partibremen.entities.exceptions.QuestionNotFoundException;
import com.hsb.partibremen.entities.exceptions.SurveyNotFoundException;
import com.hsb.partibremen.entities.model.question.Question;
import com.hsb.partibremen.entities.model.question.QuestionDto;
import com.hsb.partibremen.entities.model.survey.Survey;
import com.hsb.partibremen.entities.repo.QuestionRepo;
import com.hsb.partibremen.entities.repo.SurveyRepo;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends BaseService {
    @Autowired
    private SurveyRepo surveyRepo;
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
        if(questionRepo.findById(UUID.fromString(id)) != null){
            return questionRepo.findById(UUID.fromString(id));
        }
        throw new QuestionNotFoundException("No Question found");
    }

    public void delete(String id) {
        questionRepo.deleteById(UUID.fromString(id));
    }

    public List<Question> getQuestionsFromSurvey(String id) throws SurveyNotFoundException, QuestionNotFoundException{
        
        UUID surveyUUID = UUID.fromString(id);
        if(!surveyRepo.existsById(surveyUUID))
        {
            throw new SurveyNotFoundException("No Survey found for poi Id: " + id);
        }
        List<Question> questions = questionRepo.findBySurveyId(surveyUUID);
        if(questions.isEmpty())
        {
            throw new QuestionNotFoundException("No Questions found for poi Id: " + id);
        }
        return questions;
    }

}
