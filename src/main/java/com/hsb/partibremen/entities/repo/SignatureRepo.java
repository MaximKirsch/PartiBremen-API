package com.hsb.partibremen.entities.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.hsb.partibremen.entities.model.petition.signature.signature;

@Repository
public interface SignatureRepo extends BaseRepo<signature, UUID> {
    List<signature> findBySignerId(UUID id);
    List<signature> findByPetitionId(UUID id);
    Optional<signature> findBySignerIdAndPetitionId(UUID signerId, UUID petitionId);
}
