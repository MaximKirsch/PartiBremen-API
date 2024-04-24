package com.hsb.partibremen.entities.repo;

import com.hsb.partibremen.entities.model.poi.PoI;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PoIRepo extends BaseRepo<PoI, UUID> {

}


