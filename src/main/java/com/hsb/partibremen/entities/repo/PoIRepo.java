package com.hsb.partibremen.entities.repo;

import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.poi.PoIDto;
import com.hsb.partibremen.entities.model.user.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.List;
import java.util.UUID;

@Repository
public interface PoIRepo extends BaseRepo<PoI, UUID> {
    List<PoI> findByCreatorId(UUID creatorId);
    // String select_values = "titel";
    // @Query(value = "SELECT " + select_values + " FROM poi", nativeQuery = true)
    // List<String> selectSpecific();

    // @Query(value = "SELECT p.id, p.titel, p.description, p.created_at, p.updated_at, p.active, p.creator_id FROM poi p", nativeQuery = true)
    // List<PoI> getAllPoIsWithoutConnections();
}