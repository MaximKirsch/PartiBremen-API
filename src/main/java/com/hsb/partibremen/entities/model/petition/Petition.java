package com.hsb.partibremen.entities.model.petition;

import java.sql.Date;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "petition")
@SQLDelete(sql = "UPDATE petition SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=0")
public class Petition extends BaseEntity {
    @Column
    private String titel;
    @Column
    private String description;
    @Column
    private Date expireAt;
    @Column
    private int goal;
    @ManyToOne
    private PoI poI;


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
    public PoI getPoI(){
        return this.poI;
    }
    public void setPoI(PoI poI) {
        this.poI = poI;
    }

}
