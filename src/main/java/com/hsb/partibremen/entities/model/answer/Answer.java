package com.hsb.partibremen.entities.model.answer;

import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.Column;

public class Answer  extends BaseEntity {
    @Column
    private String Titel;
    @Column
    private String UserAnswer;

    
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
    
}
