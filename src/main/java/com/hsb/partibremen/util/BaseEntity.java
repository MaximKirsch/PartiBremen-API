package com.hsb.partibremen.util;

import java.util.Date;
import java.util.UUID;

public class BaseEntity {
    public UUID id = UUID.randomUUID();
    public Date createdAt = new Date();;
    public Date updatedAt = new Date();
}
