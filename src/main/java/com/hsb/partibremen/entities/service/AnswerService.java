package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.model.answer.Answer;
import com.hsb.partibremen.entities.model.answer.AnswerDto;
import com.hsb.partibremen.entities.repo.AnswerRepo;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnswerService extends BaseService {
    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    public Answer create(AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setTitel(answerDto.getTitel());
        answer.setUserAnswer(answerDto.getUserAnswer());

        if(!(questionService.findOne(answerDto.getQuestionId())).isPresent()){
            throw new RuntimeException();
        }
        answer.setQuestion((questionService.findOne(answerDto.getQuestionId())).get());

        if(!(userService.findOne(answerDto.getUserId())).isPresent()){
            throw new RuntimeException();
        }
        answer.setAnswerer((userService.findOne(answerDto.getUserId())).get());

        return answerRepo.save(answer);
    }

    public List<Answer> findAll() {
        return answerRepo.findAll();
    }

    public Optional<Answer> findOne(String id) {
        return answerRepo.findById(UUID.fromString(id));
    }

    public void delete(String id) {
        answerRepo.deleteById(UUID.fromString(id));
    }
}
