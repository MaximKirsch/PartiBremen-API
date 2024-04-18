package com.hsb.partibremen.entities.service;

import java.util.ArrayList;

import com.hsb.partibremen.entities.model.question.Question;
import com.hsb.partibremen.entities.util.BaseService;

public class QuestionService extends BaseService {
    public ArrayList<Question> questionList = new ArrayList<>();

    public ArrayList<Question> findAll(){
        return this.questionList;
    }
    public Question findOne(String id) {
        for (Question question : this.questionList) {
            if (question.id.toString().equals(id)) {
                return question;
            }
        }
        return null;
    }

    public void delete(String id) {
        Question questionToDelete = findOne(id);
        if(questionToDelete != null)
            questionList.remove(questionToDelete);
    }

}
