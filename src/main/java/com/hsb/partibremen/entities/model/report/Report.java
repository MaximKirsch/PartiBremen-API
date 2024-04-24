package com.hsb.partibremen.entities.model.report;

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
    private User reporter;
    @OneToOne
    private User reportedUser;
    @ManyToOne
    private PoI reportedPoi;
    @ManyToOne
    private Comment reportedComment;


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
}
