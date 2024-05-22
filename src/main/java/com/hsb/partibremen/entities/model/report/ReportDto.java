package com.hsb.partibremen.entities.model.report;

import com.hsb.partibremen.entities.enums.ReportStatus;

public class ReportDto{
    private String kommentar;
    private String title;
    private String reporterId;
    private String reportedUserId;
    private String reportedPoiId;
    private String reportedCommentId;
    private ReportStatus status;


    public String getReporterId() {
        return this.reporterId;
    }

    public void setReporterId(String reporterId) {
        this.reporterId = reporterId;
    }

    public String getReportedUserId() {
        return this.reportedUserId;
    }

    public void setReportedUserId(String reportedUserId) {
        this.reportedUserId = reportedUserId;
    }
    public String getReportedCommentId() {
        return this.reportedCommentId;
    }

    public void setReportedCommentId(String reportedCommentId) {
        this.reportedCommentId = reportedCommentId;
    }
    public String getReportedPoiId() {
        return this.reportedPoiId;
    }

    public void setReportedPoiId(String reportedPoiId) {
        this.reportedPoiId = reportedPoiId;
    }

    public String getKommentar() {
        return this.kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getTitle() {
        return this.title;
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
