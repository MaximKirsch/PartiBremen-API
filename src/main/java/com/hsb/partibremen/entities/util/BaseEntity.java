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
}
