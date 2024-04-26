package com.hsb.partibremen.entities.model.servey;
import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.user.User;
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
    @ManyToOne
    @JsonBackReference
    private User creator;
    @ManyToOne
    @JsonBackReference
    private PoI poi;

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

