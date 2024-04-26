package com.hsb.partibremen.entities.model.question;

import com.hsb.partibremen.entities.enums.QuestionType;
import com.hsb.partibremen.entities.model.survey.Survey;
import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "question")
public class Question extends BaseEntity{
    @ManyToOne
    private Survey survey;
    @Column
    private String fragestellung;
    @Column
    private QuestionType type;
    public Survey getSurvey() {
        return survey;
    }
    public void setSurvey(Survey survey) {
        this.survey = survey;
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
