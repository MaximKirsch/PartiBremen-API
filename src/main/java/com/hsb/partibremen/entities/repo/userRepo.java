package com.hsb.partibremen.entities.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface userRepo {

    @Transactional
    @Modifying
    @Query
    public void vfindOneUser(String userId);

}
