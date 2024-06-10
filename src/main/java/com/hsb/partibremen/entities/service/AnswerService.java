package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.exceptions.AnswerNotFoundException;
import com.hsb.partibremen.entities.exceptions.QuestionNotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.answer.Answer;
import com.hsb.partibremen.entities.model.answer.AnswerDto;
import com.hsb.partibremen.entities.model.question.Question;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.repo.AnswerRepo;
import com.hsb.partibremen.entities.repo.QuestionRepo;
import com.hsb.partibremen.entities.repo.UserRepo;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnswerService extends BaseService {
    @Autowired
    private AnswerRepo answerRepo;
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    public Answer create(AnswerDto answerDto) throws UserNotFoundException, QuestionNotFoundException {
        Answer answer = new Answer();
        answer.setTitel(answerDto.getTitel());
        answer.setMultipleChoiceAnswer(answerDto.getMultipleChoiceAnswer());
        answer.setSkalarAnswer(answerDto.getSkalarAnswer());
        answer.setTextAnswer(answerDto.getTextAnswer());

        Optional<Question> question = questionRepo.findById(answerDto.getQuestionId());
        if(question.isPresent()) {
            answer.setQuestion(question.get());
        } else {
            throw new QuestionNotFoundException("Question not found");
        }

        Optional<User> user = userRepo.findById(answerDto.getUserId());
        if(user.isPresent()) {
            answer.setAnswerer(user.get());
        } else {
            throw new UserNotFoundException("User not found");
        }

        return answerRepo.save(answer);
    }


    public List<Answer> findAll() {
        return answerRepo.findAll();
    }

    public Optional<Answer> findOne(String id) throws AnswerNotFoundException {
        if(answerRepo.findById(UUID.fromString(id)) != null){
            return answerRepo.findById(UUID.fromString(id));
        }
        throw new AnswerNotFoundException();
    }

    public void delete(String id) {
        answerRepo.deleteById(UUID.fromString(id));
    }

    public List<Answer> findAllByQuestionId(UUID questionId) throws QuestionNotFoundException {
        if(questionRepo.findById(questionId).isPresent()) {
            return answerRepo.findByQuestionId(questionId);
        } else {
            throw new QuestionNotFoundException("Question not found");
        }
    }

}
