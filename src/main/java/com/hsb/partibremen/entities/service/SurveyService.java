package com.hsb.partibremen.entities.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsb.partibremen.entities.model.servey.Survey;
import com.hsb.partibremen.entities.model.servey.SurveyDto;
import com.hsb.partibremen.entities.repo.SurveyRepo;
import com.hsb.partibremen.entities.util.BaseService;

@Service
public class SurveyService extends BaseService {
    @Autowired
    private SurveyRepo surveyRepo;
    @Autowired
    private UserService userService;
    public Survey create(SurveyDto surveyDto) {
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

    public Optional<Survey> findOne(String id){
        return surveyRepo.findById(UUID.fromString(id));
    }

    public void deleteSurvey(String id) {
        surveyRepo.deleteById(UUID.fromString(id));
    }
    

    

   

    

    

    

}

