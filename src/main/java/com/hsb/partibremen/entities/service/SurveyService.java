package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.exceptions.SurveyNotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.survey.Survey;
import com.hsb.partibremen.entities.model.survey.SurveyDto;
import com.hsb.partibremen.entities.repo.SurveyRepo;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SurveyService extends BaseService {
    @Autowired
    private SurveyRepo surveyRepo;
    @Autowired
    private UserService userService;
    public Survey create(SurveyDto surveyDto) throws UserNotFoundException {
        Survey survey = new Survey();
        survey.setTitel(surveyDto.getTitel());
        survey.setBeschreibung(surveyDto.getBeschreibung());
        survey.setExpiresAt(surveyDto.getExpiresAt());

        if(!userService.findOne(surveyDto.getUserId()).isPresent()){
            throw new RuntimeException();
        }
        survey.setCreator(userService.findOne(surveyDto.getUserId()).get());

        return surveyRepo.save(survey);
    }

    public List<Survey> findAll(){
        return surveyRepo.findAll();
    }

    public Optional<Survey> findOne(String id) throws SurveyNotFoundException {
        if(surveyRepo.findById(UUID.fromString(id)) != null){
            return surveyRepo.findById(UUID.fromString(id));
        }
        throw new SurveyNotFoundException();
    }

    public void deleteSurvey(String id) {
        surveyRepo.deleteById(UUID.fromString(id));
    }
    
    /*
    public List<Survey> findByPoiId(String poiId) throws SurveyNotFoundException, PoINotFoundException {
        UUID poiUUID = UUID.fromString(poiId);
        if(!poiRepo.existsById(poiUUID))
        {
            throw new PoINotFoundException();
        }
        List<Survey> surveys = poIService.findOne(poiId).get().getSurveys();
        if(surveys.isEmpty())
        {
            throw new SurveyNotFoundException();
        }
        return surveys;
    }
     */

}

