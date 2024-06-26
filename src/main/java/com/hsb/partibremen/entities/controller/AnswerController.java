package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.exceptions.AnswerNotFoundException;
import com.hsb.partibremen.entities.exceptions.QuestionNotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.answer.Answer;
import com.hsb.partibremen.entities.model.answer.AnswerDto;
import com.hsb.partibremen.entities.service.AnswerService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AnswerController extends BaseController {
    @Autowired
    private AnswerService answerService;

    @PostMapping("/answer")
    public Answer create(@RequestBody AnswerDto answerDto) throws UserNotFoundException, QuestionNotFoundException {
        return answerService.create(answerDto);
    }

    @GetMapping("/answer")
    public List<Answer> findAll() {
        return answerService.findAll();
    }

    @GetMapping("/answer/{id}")
    public Optional<Answer> findOne(@PathVariable String id) {
        try {
            return answerService.findOne(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Answer not found", ex);
        }

    }

    @PutMapping("/answer/{id}")
    public Optional<Answer> update(@PathVariable String id, @RequestBody AnswerDto answerDto)
            throws AnswerNotFoundException {
        Optional<Answer> optionalAnswer = answerService.findOne(id);
        if (optionalAnswer.isPresent()) {
            Answer answer = optionalAnswer.get();
            answer.setTitel(answerDto.getTitel());

            // Update answer fields based on the type
            if (answerDto.getMultipleChoiceAnswer() != null) {
                answer.setMultipleChoiceAnswer(answerDto.getMultipleChoiceAnswer());
            }
            if (answerDto.getSkalarAnswer() != 0) {
                answer.setSkalarAnswer(answerDto.getSkalarAnswer());
            }
            if (answerDto.getTextAnswer() != null) {
                answer.setTextAnswer(answerDto.getTextAnswer());
            }
        }
        return optionalAnswer;
    }

    @DeleteMapping("/answer/{id}")
    public void delete(@PathVariable String id) {
        answerService.delete(id);
    }

    @GetMapping("/answer/question/{questionId}")
    public List<Answer> getAllAnswersByQuestionId(@PathVariable UUID questionId) {
        try {
            return answerService.findAllByQuestionId(questionId);
        } catch (QuestionNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found", ex);
        }
    }

    @GetMapping("/answer/user/{userId}/question/{questionId}")
    public List<Answer> getAllAnswersByUserIdAndQuestionId(@PathVariable UUID userId, @PathVariable UUID questionId) {
        try {
            return answerService.findAllByUserIdAndQuestionId(userId, questionId);
        } catch (UserNotFoundException | QuestionNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }
}
