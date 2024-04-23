package com.hsb.partibremen.entities.enums;

public enum POIStatus {
    UNPLANNED("Nicht geplant", 0),
    PLANNED("Geplant", 1),
    IN_PROGRESS("In Arbeit", 2),
    FINISHED("Fertig", 3),
    DISCARDED("Verworfen", 4),
    CANCELLED("Abgebrochen", 5),
    DELETED("Gelöscht", 6);

    private String bezeichnung;
    private int id;

    POIStatus(String bezeichnung, int id){
        this. bezeichnung = bezeichnung;
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
