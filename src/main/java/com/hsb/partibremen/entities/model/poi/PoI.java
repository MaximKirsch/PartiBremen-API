package com.hsb.partibremen.entities.model.poi;

import com.hsb.partibremen.entities.model.question.Question;
import com.hsb.partibremen.entities.model.servey.Survey;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "poi")
public class PoI extends BaseEntity {
    @Column
    private String Titel;
    @Column
    private String description;
    @Column
    private Boolean active;
    @ManyToOne
    private User creator;

    @OneToMany
    private List<Survey> surveys;

    
    public String getTitel() {
        return Titel;
    }
    public void setTitel(String titel) {
        Titel = titel;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        description = description;
    }

    public User getCreator(){
        return this.creator;
    }

    public void setAnswerer(User creator) {
        this.creator = creator;
    }

    public Boolean getActive(){
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Survey> getSurveys() { return this.surveys; }
}
