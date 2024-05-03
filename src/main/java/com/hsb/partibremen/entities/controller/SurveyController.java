package com.hsb.partibremen.entities.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hsb.partibremen.entities.model.survey.Survey;
import com.hsb.partibremen.entities.model.survey.SurveyDto;
import com.hsb.partibremen.entities.service.SurveyService;
import com.hsb.partibremen.entities.util.BaseController;



@RestController()

public class SurveyController extends BaseController {
    @Autowired
    public SurveyService surveyService;

    @PostMapping("/survey")
    public Survey create(@RequestBody SurveyDto serveyDto) {
        return surveyService.create(serveyDto);

    }

    @GetMapping("/survey")
    public List<Survey> findAll() {
        return surveyService.findAll();
    }

    @GetMapping("/survey/{id}")
    public Optional<Survey> findOne(@PathVariable String id) {
        return surveyService.findOne(id);
    }

    @DeleteMapping("/survey/{id}")
    public void deleteSurvey(@PathVariable String id) {
        surveyService.deleteSurvey(id);
    }

    

}
