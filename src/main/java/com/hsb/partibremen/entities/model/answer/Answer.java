package com.hsb.partibremen.entities.model.answer;

import com.hsb.partibremen.entities.model.question.Question;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer  extends BaseEntity {
    @Column
    private String Titel;
    @Column
    private String UserAnswer;
    @ManyToOne
    private Question question;
    @ManyToOne
    private User answerer;

    
    public String getTitel() {
        return Titel;
    }
    public void setTitel(String titel) {
        Titel = titel;
    }
    public String getUserAnswer() {
        return UserAnswer;
    }
    public void setUserAnswer(String userAnswer) {
        UserAnswer = userAnswer;
    }

    public User getAnswerer(){
        return this.answerer;
    }

    public void setAnswerer(User answerer) {
        this.answerer = answerer;
    }

    public Question getQuestion(){
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
