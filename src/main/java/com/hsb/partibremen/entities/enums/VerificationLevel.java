package com.hsb.partibremen.entities.enums;

public enum VerificationLevel {
    NONE("Nicht vorhanden", 0), 
    EMAIL("Email", 1), 
    AUSWEIS("Ausweis", 2);

    private String bezeichnung;
    private int id;
    
    private VerificationLevel(String bezeichnung, int id) {
        this.bezeichnung = bezeichnung;
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
