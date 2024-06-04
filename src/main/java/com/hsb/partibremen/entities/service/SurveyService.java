package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.exceptions.PoINotFoundException;
import com.hsb.partibremen.entities.exceptions.SurveyNotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.survey.Survey;
import com.hsb.partibremen.entities.model.survey.SurveyDto;
import com.hsb.partibremen.entities.repo.PoIRepo;
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
    public PoIRepo poiRepo;
    @Autowired
    private SurveyRepo surveyRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private PoIService poiService;

    public Survey create(SurveyDto surveyDto) throws UserNotFoundException, PoINotFoundException {
        Survey survey = new Survey();
        survey.setTitel(surveyDto.getTitel());
        survey.setBeschreibung(surveyDto.getBeschreibung());
        survey.setExpiresAt(surveyDto.getExpiresAt());

        if (!userService.findOne(surveyDto.getUserId()).isPresent()) {
            throw new UserNotFoundException("User not found with ID: " + surveyDto.getUserId());
        }
        survey.setCreator(userService.findOne(surveyDto.getUserId()).get());

        if (!poiService.findOne(surveyDto.getPoiId()).isPresent()) {
            throw new PoINotFoundException("PoI not found with ID: " + surveyDto.getPoiId());
        }
        survey.setPoi(poiService.findOne(surveyDto.getPoiId()).get());

        return surveyRepo.save(survey);
    }

    public List<Survey> findAll() {
        return surveyRepo.findAll();
    }

    public Optional<Survey> findOne(String id) throws SurveyNotFoundException {
        if(surveyRepo.findById(UUID.fromString(id)) != null){
            return surveyRepo.findById(UUID.fromString(id));
        }
        throw new SurveyNotFoundException("Survey not found");
    }

    public void deleteSurvey(String id) {
        surveyRepo.deleteById(UUID.fromString(id));
    }

    public Optional<Survey> updateSurvey(SurveyDto survey, String id){
        Optional<Survey> optionalSurvey = surveyRepo.findById(UUID.fromString(id));
        if(optionalSurvey.isPresent()){
            Survey survey2 = optionalSurvey.get();
            if(survey.getTitel() != null){
                survey2.setTitel(survey.getTitel());
            }
            if(survey.getBeschreibung() != null){
                survey2.setBeschreibung(survey.getBeschreibung());
        
            }
            if(survey.getExpiresAt() != null){
                survey2.setExpiresAt(survey.getExpiresAt());
            }
            surveyRepo.save(survey2);
        }
        return optionalSurvey;
    } 
    
    
    public List<Survey> findByPoiId(String id) throws PoINotFoundException, SurveyNotFoundException  {
        UUID poiUUID = UUID.fromString(id);
        if(!poiRepo.existsById(poiUUID))
        {
            throw new PoINotFoundException("No Poi found for poi Id: " + id);
        }
        List<Survey> surveys = surveyRepo.findByPoiId(poiUUID);
        if(surveys.isEmpty())
        {
            throw new SurveyNotFoundException("No Survey found for poi Id: " + id);
        }
        return surveys;
    }
     

}

