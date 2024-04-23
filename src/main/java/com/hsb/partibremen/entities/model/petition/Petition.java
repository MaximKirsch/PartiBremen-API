package com.hsb.partibremen.entities.model.petition;

import java.sql.Date;

import com.hsb.partibremen.entities.util.BaseEntity;

public class Petition extends BaseEntity {
    //@Column
    private String titel;
    //@Column
    private String description;
    //@Column
    private Date expireAt;
    //@Column
    private int goal;


    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getExpireAt() {
        return expireAt;
    }
    public void setExpireAt(Date expireAt) {
        this.expireAt = expireAt;
    }
    public int getGoal() {
        return goal;
    }
    public void setGoal(int goal) {
        this.goal = goal;
    }
    
    
}