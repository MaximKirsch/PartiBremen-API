package com.hsb.partibremen.entities.enums;

public enum VoteType {
    UP("Upvote", 0), 
    DOWN("Downvote", 1);

    private String bezeichnung;
    private int id;

    VoteType(String bezeichnung, int id){
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
