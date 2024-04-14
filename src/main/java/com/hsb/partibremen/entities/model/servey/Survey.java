package com.hsb.partibremen.entities.model.servey;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;


import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.util.BaseEntity;

public class Survey extends BaseEntity {
    
    //@Collumn
    private String titel;

    //@Collumn
    private String beschreibung;

    //@Collumn
    private Date expiresAt;

    //@Collumn
    private String userId;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Date getExpiresAt() {
        return expiresAt;
    }
    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public String getBeschreibung() {
        return beschreibung;
    }
    public String getTitel() {
        return titel;
    }
}

