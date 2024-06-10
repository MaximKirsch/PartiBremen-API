package com.hsb.partibremen.entities.model.answer;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.hsb.partibremen.entities.enums.MultipleChoice;
import com.hsb.partibremen.entities.model.question.Question;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "answer")
@SQLDelete(sql = "UPDATE answer SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=0")
public class Answer  extends BaseEntity {
    @Column
    private String Titel;
    @Column
    private MultipleChoice multipleChoiceAnswer;
    @Column
    private int skalarAnswer;
    @Column
    private String textAnswer;
    @ManyToOne
    private Question question;
    @ManyToOne
    private User answerer;


    
    
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
    public String getTitel() {
        return Titel;
    }
    public void setTitel(String titel) {
        Titel = titel;
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
