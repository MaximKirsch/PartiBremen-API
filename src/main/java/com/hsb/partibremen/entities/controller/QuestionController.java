package com.hsb.partibremen.entities.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsb.partibremen.entities.model.question.Question;
import com.hsb.partibremen.entities.model.question.QuestionDto;
import com.hsb.partibremen.entities.service.QuestionService;
import com.hsb.partibremen.entities.util.BaseController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController()


public class QuestionController extends BaseController {
    private QuestionService questionService = new QuestionService();

  @PostMapping("/question")
  public Question createQuestion(@RequestBody QuestionDto questionDto) {
    Question question = new Question();
    question.setFragestellung(questionDto.getFragestellung());
    question.setType(questionDto.getType());
    question.setSurveyId(question.getSurveyId());
    questionService.questionList.add(question);
    return question;
    
    }

    @GetMapping("/question")
    public ArrayList<Question> getAllQusetions() {
        return questionService.findAll();
    }

    @GetMapping("/question/{id}")
    public Question getOneQuestion(@PathVariable String id) {
        return questionService.findOne(id);
    }

    @DeleteMapping("/question/{id}/delete")
    public void deleteQuestion(@PathVariable String id) {
        questionService.delete(id);
    }
}
