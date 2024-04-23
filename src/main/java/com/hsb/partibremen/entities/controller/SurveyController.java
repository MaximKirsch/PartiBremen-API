package com.hsb.partibremen.entities.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hsb.partibremen.entities.model.servey.Survey;
import com.hsb.partibremen.entities.model.servey.SurveyDto;
import com.hsb.partibremen.entities.service.SurveyService;
import com.hsb.partibremen.entities.util.BaseController;



@RestController()

public class SurveyController extends BaseController {
    @Autowired
    public SurveyService surveyService;

    @PostMapping("servey/create")
    public Survey create(@RequestBody SurveyDto serveyDto) {
        return surveyService.create(serveyDto);

    }

    @GetMapping("/servey/find-all")
    public List<Survey> findAll() {
        return surveyService.findAll();
    }

    @GetMapping("/servey/findById")
    public Optional<Survey> findOne(@RequestParam String id) {
        return surveyService.findOne(id);
    }

    @DeleteMapping("/servey/delete")
    public void deleteSurvey(@RequestParam String id) {
        surveyService.deleteSurvey(id);
    }

    // ToDO: Add absolvieren (Medium noch nicht vorhanden)

    

}
