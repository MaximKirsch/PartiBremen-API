package com.hsb.partibremen.entities.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hsb.partibremen.entities.exceptions.QuestionNotFoundException;
import com.hsb.partibremen.entities.exceptions.SurveyNotFoundException;
import com.hsb.partibremen.entities.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

@RestController()
public class QuestionController extends BaseController {
  @Autowired
  private QuestionService questionService;

  @PostMapping("/question")
  public Question createQuestion(@RequestBody QuestionDto questionDto) {
    try {
      System.out.println(questionDto.surveyId);
      System.out.println(questionDto.getFragestellung());
      System.out.println(UUID.fromString(questionDto.surveyId));
      return questionService.create(questionDto);
    } catch(Exception ex) {
      throw new ResponseStatusException(
              HttpStatus.NOT_FOUND, "User not found", ex);
      }

    }

    @GetMapping("/question")
    public List<Question> getAllQusetions() {
        return questionService.findAll();
    }

    @GetMapping("/question/{id}")
    public Optional<Question> getOneQuestion(@PathVariable String id) {
      try {
        return questionService.findOne(id);
      } catch (Exception ex) {
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Question not found", ex);
      }
    }

    @GetMapping("/question/surveyid/{id}")
    public List<Question> getQuestionsFromSurvey(@PathVariable String id){
      try {
        return questionService.getQuestionsFromSurvey(id);
      } catch (SurveyNotFoundException ex) {
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Survey not found", ex);
      } catch (QuestionNotFoundException ex) {
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Question not found", ex);
      }
    }

    @DeleteMapping("/question/{id}")
    public void deleteQuestion(@PathVariable String id) {
        questionService.delete(id);
    }
}
