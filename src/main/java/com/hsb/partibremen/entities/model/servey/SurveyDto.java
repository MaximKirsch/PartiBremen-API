package com.hsb.partibremen.entities.model.servey;

import java.sql.Date;
import java.util.UUID;

import com.hsb.partibremen.entities.model.user.User;

public class SurveyDto {
    private String titel;
    private String beschreibung;
    private Date expiresAt;
    private String userId;
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
}
