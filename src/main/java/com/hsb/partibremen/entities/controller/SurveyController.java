package com.hsb.partibremen.entities.controller;
import java.util.List;
import java.util.Optional;

import com.hsb.partibremen.entities.exceptions.PoINotFoundException;
import com.hsb.partibremen.entities.exceptions.SurveyNotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.hsb.partibremen.entities.model.survey.Survey;
import com.hsb.partibremen.entities.model.survey.SurveyDto;
import com.hsb.partibremen.entities.service.SurveyService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SurveyController extends BaseController {
    @Autowired
    public SurveyService surveyService;

    @PostMapping("/survey")
    public Survey create(@RequestBody SurveyDto surveyDto) {
        try {
            return surveyService.create(surveyDto);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @GetMapping("/survey")
    public List<Survey> findAll() {
        return surveyService.findAll();
    }

    @GetMapping("/survey/{id}")
    public Optional<Survey> findOne(@PathVariable String id) {
        try {
            return surveyService.findOne(id);
        } catch (SurveyNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    @DeleteMapping("/survey/{id}")
    public void deleteSurvey(@PathVariable String id) {
        surveyService.deleteSurvey(id);
    }

    /*
    @GetMapping("/survey/poi/{poiId}")
    public List<Survey> findByPOIId(@PathVariable String poiId) {
        try {
            return surveyService.findByPoiId(poiId);
        } catch (PoINotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "POI Not Found", ex);
        } catch (SurveyNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Survey Not Found", ex);
        }
    }
     */

}
