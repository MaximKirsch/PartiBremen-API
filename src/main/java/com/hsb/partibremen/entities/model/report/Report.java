package com.hsb.partibremen.entities.model.report;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hsb.partibremen.entities.enums.ReportStatus;
import com.hsb.partibremen.entities.model.comment.Comment;
import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.util.BaseEntity;
import com.hsb.partibremen.entities.util.BaseService;
import jakarta.persistence.*;

@Entity
@Table(name = "report")
public class Report extends BaseEntity {

    @Column
    private String kommentar;
    @Column
    private String title;

    @ManyToOne
    @JsonIgnore
    private User reporter;
    @ManyToOne
    @JsonIgnore
    private User reportedUser;
    @ManyToOne
    @JsonIgnore
    private PoI reportedPoi;
    @ManyToOne
    @JsonIgnore
    private Comment reportedComment;    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReportStatus status;


    public User getReporter() {
        return this.reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }
    public User getReportedUser() {
        return this.reportedUser;
    }

    public void setReportedUser(User reportedUser) {
        this.reportedUser = reportedUser;
    }

    public PoI getReportedPoi() {
        return this.reportedPoi;
    }

    public void setReportedPoi(PoI reportedPoi) {
        this.reportedPoi = reportedPoi;
    }

    public Comment getReportedComment() {
        return this.reportedComment;
    }

    public void setReportedComment(Comment reportedComment) {
        this.reportedComment = reportedComment;
    }
    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }
    
}
