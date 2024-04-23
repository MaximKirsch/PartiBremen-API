package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.model.answer.Answer;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
@Service
public class AnswerService extends BaseService {
    public ArrayList<Answer> answerList = new ArrayList<>();

    public ArrayList<Answer> findAll() {
        return this.answerList;
    }

    public Answer findOne(String id) {
        for (Answer answer : this.answerList) {
            if (answer.id.toString().equals(id)) {
                return answer;
            }
        }
        return null;
    }

    public void delete(String id) {
        Iterator<Answer> iterator = answerList.iterator();
        while (iterator.hasNext()) {
            Answer answer = iterator.next();
            if (answer.id.toString().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }
}
