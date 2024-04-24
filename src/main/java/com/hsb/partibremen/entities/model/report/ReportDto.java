package com.hsb.partibremen.entities.model.report;

public class ReportDto{
    private String kommentar;
    private String title; //.

    private String reporterId;

    private String reportedUserId;

    private String reportedPoiId;
    private String reportedCommentId;

    public String getReporterId() {
        return reporterId;
    }

    public void setReporterId(String reporterId) {
        this.reporterId = reporterId;
    }

    public String getReportedUserId() {
        return reportedUserId;
    }

    public void setReportedUserId(String reportedUserId) {
        this.reportedUserId = reportedUserId;
    }
    public String getReportedCommentId() {
        return reportedCommentId;
    }

    public void setReportedCommentId(String reportedCommentId) {
        this.reportedCommentId = reportedCommentId;
    }
    public String getReportedPoiId() {
        return reportedPoiId;
    }

    public void setReportedPoiId(String reportedPoiId) {
        this.reportedPoiId = reportedPoiId;
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
