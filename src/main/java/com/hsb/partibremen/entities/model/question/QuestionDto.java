package com.hsb.partibremen.entities.model.question;

import com.hsb.partibremen.entities.enums.QuestionType;

public class QuestionDto {
    public String surveyId;
    private String fragestellung;
    private QuestionType type;
    public String getSurveyId() {
        return this.surveyId;
    }
    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }
    public String getFragestellung() {
        return fragestellung;
    }
    public void setFragestellung(String fragestellung) {
        this.fragestellung = fragestellung;
    }
    public QuestionType getType() {
        return type;
    }
    public void setType(QuestionType type) {
        this.type = type;
    }
}
