package com.hsb.partibremen.entities.model.question;

import com.hsb.partibremen.entities.enums.QuestionType;
import com.hsb.partibremen.entities.util.BaseEntity;

public class Question extends BaseEntity{
    //@Collumn
    private String surveyId;
    //@Collumn
    private String fragestellung;
    //@Collumn
    private QuestionType type;
    public String getSurveyId() {
        return surveyId;
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
