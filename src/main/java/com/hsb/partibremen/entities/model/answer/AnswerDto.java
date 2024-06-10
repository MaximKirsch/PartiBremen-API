package com.hsb.partibremen.entities.model.answer;

import java.util.UUID;

import com.hsb.partibremen.entities.enums.MultipleChoice;
import com.hsb.partibremen.entities.model.user.User;



public class AnswerDto {


    private String titel;
    private MultipleChoice multipleChoiceAnswer;
    private int skalarAnswer;
    private String textAnswer;
    private UUID questionId;
    private UUID userId;
    private User answerer;


    
    public User getAnswerer() {
        return answerer;
    }
    public void setAnswerer(User answerer) {
        this.answerer = answerer;
    }
    public String getTitel() {
        return this.titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public UUID getQuestionId() {
        return this.questionId;
    }
    public void setQuestionId(UUID questionId) {
        this.questionId = questionId;
    }
    public MultipleChoice getMultipleChoiceAnswer() {
        return multipleChoiceAnswer;
    }
    public void setMultipleChoiceAnswer(MultipleChoice multipleChoiceAnswer) {
        this.multipleChoiceAnswer = multipleChoiceAnswer;
    }
    public int getSkalarAnswer() {
        return skalarAnswer;
    }
    public void setSkalarAnswer(int skalarAnswer) {
        this.skalarAnswer = skalarAnswer;
    }
    public String getTextAnswer() {
        return textAnswer;
    }
    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }
    
}
