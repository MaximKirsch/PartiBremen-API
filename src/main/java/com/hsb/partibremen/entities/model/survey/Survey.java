package com.hsb.partibremen.entities.model.survey;
import java.sql.Date;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "survey")
@SQLDelete(sql = "UPDATE survey SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=0")
public class Survey extends BaseEntity {
    
    @Column
    private String titel;
    @Column
    private String beschreibung;
    @Column
    private Date expiresAt;
    @ManyToOne
    @JsonBackReference
    private User creator;
    @ManyToOne
    @JsonBackReference
    private PoI poi;

    public PoI getPoi() {
        return poi;
    }
    public void setPoi(PoI poi) {
        this.poi = poi;
    }
    public User getCreator() {
        return this.creator;
    }
    public void setCreator(User creator) {
        this.creator = creator;
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

