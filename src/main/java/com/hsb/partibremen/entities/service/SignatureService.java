package com.hsb.partibremen.entities.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsb.partibremen.entities.exceptions.PetitionNotFoundException;
import com.hsb.partibremen.entities.exceptions.SignatureAlreadyExistsException;
import com.hsb.partibremen.entities.exceptions.SignatureNotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.petition.signature.signature;
import com.hsb.partibremen.entities.model.petition.signature.signatureDto;
import com.hsb.partibremen.entities.repo.SignatureRepo;
import com.hsb.partibremen.entities.util.BaseService;

@Service
public class SignatureService extends BaseService {
    @Autowired
    public SignatureRepo signatureRepo;
    @Autowired
    public UserService userService;
    @Autowired
    private PetitionService petitionService;

    public signature create(signatureDto SignatureDto) throws UserNotFoundException, PetitionNotFoundException, SignatureAlreadyExistsException{
        signature signature = new signature();
        if(signatureRepo.findBySignerIdAndPetitionId(UUID.fromString(SignatureDto.getSignerId()), UUID.fromString(SignatureDto.getPetitionId())).isPresent()){
            throw new SignatureAlreadyExistsException("Signature already exists");
        }
        if(!(userService.findOne(SignatureDto.getSignerId())).isPresent()){
            throw new RuntimeException();
        }
        signature.setSigner((userService.findOne(SignatureDto.getSignerId())).get());
        if(!(this.petitionService.findOne(SignatureDto.getPetitionId())).isPresent()){
            throw new RuntimeException();
        }
        signature.setPetition((petitionService.findOne(SignatureDto.getPetitionId())).get());

        return this.signatureRepo.save(signature);   
    }

    public List<signature> findAll(){
        return this.signatureRepo.findAll();
    }

    public Optional<signature> findOne(String id) throws SignatureNotFoundException{
        if(signatureRepo.findById(UUID.fromString(id)).isPresent()){
            return signatureRepo.findById(UUID.fromString(id));
        }
        throw new RuntimeException();
    }

    public List<signature> findByUserId(String userId) throws UserNotFoundException{
        if(!(userService.findOne(userId)).isPresent()){
            throw new RuntimeException();
        }
        return signatureRepo.findBySignerId(UUID.fromString(userId));
    }

    public List<signature> findByPetitionId(String petitionId) throws PetitionNotFoundException{
        if(!(petitionService.findOne(petitionId)).isPresent()){
            throw new RuntimeException();
        }
        return signatureRepo.findByPetitionId(UUID.fromString(petitionId));
    }

    public Optional<signature> findBySignerIdAndPetitionId(String signerId, String petitionId) throws SignatureNotFoundException{ 
        if(signatureRepo.findBySignerIdAndPetitionId(UUID.fromString(signerId), UUID.fromString(petitionId)).isPresent()){
            return signatureRepo.findBySignerIdAndPetitionId(UUID.fromString(signerId), UUID.fromString(petitionId));
        }
        throw new RuntimeException();
    }

    public void delete(String id) {
        signatureRepo.deleteById(UUID.fromString(id));
    }
    
}
