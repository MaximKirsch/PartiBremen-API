package com.hsb.partibremen.entities.util;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class BaseEntity {
    @Id
    @GeneratedValue
    @Column
    public UUID id;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt = new Date();
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt = new Date();
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    
    @Column(name="is_deleted")
    public boolean isDeleted = false;
    
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
