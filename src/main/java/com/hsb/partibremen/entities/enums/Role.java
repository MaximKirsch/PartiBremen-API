package com.hsb.partibremen.entities.enums;

public enum Role {
    DEFAULT("DEFAULT", 0),
    USER("User", 1),
    CREATOR("Creator", 2),
    MODERATOR("Moderator", 3),
    ADMIN("Admin", 4),
    DECIDER("Decider", 5);

    private String bezeichung;
    private int id;

    Role(String bezeichnung, int id){
        this.bezeichung = bezeichnung;
        this.id = id;
    }

    public String getBezeichung() {
        return bezeichung;
    }

    public void setBezeichung(String bezeichung) {
        this.bezeichung = bezeichung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
