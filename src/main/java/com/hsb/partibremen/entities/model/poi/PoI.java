package com.hsb.partibremen.entities.model.poi;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hsb.partibremen.entities.model.comment.Comment;
import com.hsb.partibremen.entities.model.report.Report;
import com.hsb.partibremen.entities.model.survey.Survey;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.voting.Voting;
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
    @Column
    private String latitude;
    @Column
    private String longitude;
    @ManyToOne
    @JsonBackReference
    private User creator;
    @OneToMany(mappedBy = "reportedPoi")
    @JsonManagedReference
    private List<Report> reports;
    @OneToMany(mappedBy = "poi")
    @JsonManagedReference
    private List<Survey> surveys;
    @OneToMany(mappedBy = "votedPoi")
    @JsonManagedReference
    private List<Voting> votings;
    @OneToMany(mappedBy = "poI")
    @JsonManagedReference
    private List<Comment> comments;

    public String getLtitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
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
        this.description = description;
    }

    public User getCreator(){
        return this.creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Boolean getActive(){
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Survey> getSurveys() { return this.surveys; }

    public List<Report> getReports() { return this.reports; }

    public List<Voting> getVoting() { return this.votings; }

    public List<Comment> getComments() {return this.comments; }

    
    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }
    public void setVotings(List<Voting> votings) {
        this.votings = votings;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
