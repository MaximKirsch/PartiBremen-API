package com.hsb.partibremen.entities.model.servey;

import java.sql.Date;

import com.hsb.partibremen.entities.util.BaseEntity;

public class Servey extends BaseEntity {
    
    //@Collumn
    private String titel;

    //@Collumn
    private String beschreibung;

    private Date expiresAt;

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

