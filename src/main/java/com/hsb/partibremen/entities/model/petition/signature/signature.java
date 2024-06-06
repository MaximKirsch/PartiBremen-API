package com.hsb.partibremen.entities.model.petition.signature;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hsb.partibremen.entities.model.petition.Petition;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.util.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "signature")
@SQLDelete(sql = "UPDATE signature SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=0")
public class signature extends BaseEntity{
    @ManyToOne
    @JsonBackReference
    private Petition petition;
    @ManyToOne
    @JsonBackReference
    private User signer;

    public Petition getPetition() {
        return petition;
    }

    public void setPetition(Petition petition) {
        this.petition = petition;
    }

    public User getSigner() {
        return signer;
    }

    public void setSigner(User signer) {
        this.signer = signer;
    }

}
