package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.model.answer.Answer;
import com.hsb.partibremen.entities.model.answer.AnswerDto;
import com.hsb.partibremen.entities.service.AnswerService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AnswerController extends BaseController {
    private AnswerService answerService = new AnswerService();

    @PostMapping("/answer")
    public Answer create(@RequestBody AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setTitel(answerDto.getTitel());
        answer.setUserAnswer(answerDto.getUserAnswer());
        answerService.answerList.add(answer);
        return answer;
    }

    @GetMapping("/answer")
    public ArrayList<Answer> findAll() {
        return answerService.findAll();
    }

    @GetMapping("/answer/{id}")
    public Answer findOne(@PathVariable String id) {
        return answerService.findOne(id);
    }

    @PutMapping("/answer/{id}")
    public Answer update(@PathVariable String id, @RequestBody AnswerDto answerDto) {
        Answer answer = answerService.findOne(id);
        if (answer != null) {
            answer.setTitel(answerDto.getTitel());
            answer.setUserAnswer(answerDto.getUserAnswer());
        }
        return answer;
    }

    @DeleteMapping("/answer/{id}")
    public void delete(@PathVariable String id) {
        answerService.delete(id);
    }
}
