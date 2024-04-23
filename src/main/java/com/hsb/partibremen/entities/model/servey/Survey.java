package com.hsb.partibremen.entities.model.servey;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;


import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "survey")
public class Survey extends BaseEntity {
    
    @Column
    private String titel;

    @Column
    private String beschreibung;

    @Column
    private Date expiresAt;

    @Column
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

