package com.hsb.partibremen.entities.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hsb.partibremen.entities.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsb.partibremen.entities.model.question.Question;
import com.hsb.partibremen.entities.model.question.QuestionDto;
import com.hsb.partibremen.entities.service.QuestionService;
import com.hsb.partibremen.entities.util.BaseController;

import org.springframework.web.bind.annotation.RequestBody;

@RestController()
public class QuestionController extends BaseController {
  @Autowired
  private QuestionService questionService;

  @PostMapping("/question")
  public Question createQuestion(@RequestBody QuestionDto questionDto) {
    System.out.println(questionDto.surveyId);
    System.out.println(questionDto.getFragestellung());
    System.out.println(UUID.fromString(questionDto.surveyId));
    return questionService.create(questionDto);
    }

    @GetMapping("/question")
    public List<Question> getAllQusetions() {
        return questionService.findAll();
    }

    @GetMapping("/question/{id}")
    public Optional<Question> getOneQuestion(@PathVariable String id) {
        return questionService.findOne(id);
    }

    @DeleteMapping("/question/{id}")
    public void deleteQuestion(@PathVariable String id) {
        questionService.delete(id);
    }
}
