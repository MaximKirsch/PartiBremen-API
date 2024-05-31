package com.hsb.partibremen.entities.model.survey;

import java.sql.Date;

public class SurveyDto {
    private String titel;
    private String beschreibung;
    private Date expiresAt;
    private String userId;
    private String poiId; 



    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public String getBeschreibung() {
        return beschreibung;
    }
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    public Date getExpiresAt() {
        return expiresAt;
    }
    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }
    public String getPoiId() {
        return poiId;
    }
    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }
}
