package com.hsb.partibremen.entities.enums;

public enum QuestionType {
    SKALA("Skala", 0),
    //BOOLEAN("Ja/Nein", 1),
    SATZ("Satz", 1),
    M_CHOICE("Multiply Choice", 2);

    private String bezeichnung;
    private int id;

    private QuestionType(String bezeichnung, int id) {
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
