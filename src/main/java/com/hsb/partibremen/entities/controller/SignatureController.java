package com.hsb.partibremen.entities.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.hsb.partibremen.entities.exceptions.PetitionNotFoundException;
import com.hsb.partibremen.entities.exceptions.SignatureAlreadyExistsException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.petition.signature.signature;
import com.hsb.partibremen.entities.model.petition.signature.signatureDto;
import com.hsb.partibremen.entities.service.SignatureService;
import com.hsb.partibremen.entities.util.BaseController;

@RestController
public class SignatureController extends BaseController {
    @Autowired
    public SignatureService signatureService;

    @PostMapping("/signature")
    public signature create(@RequestBody signatureDto SignatureDto) {
        try {
            return signatureService.create(SignatureDto);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not Found", ex);
        } catch (PetitionNotFoundException ex) {
           throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Petition not Found", ex);
        } catch (SignatureAlreadyExistsException ex){
            throw new ResponseStatusException(
                HttpStatus.IM_USED, "A Signature is already presented", ex);
        }
    }

    @GetMapping("/signature")
    public List<signature> findAll(){
        return signatureService.findAll();
    }

    @GetMapping("/signature/{id}")
    public Optional<signature> findOne(@PathVariable String id){
        try {
            return signatureService.findOne(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Signature not Found", ex);
        }
    }

    @GetMapping("/signature/user/{signerId}")
    public List<signature> findByUserId(@PathVariable String signerId){
        
        try {
            return signatureService.findByUserId(signerId);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not found", ex);
        }
    }

    @GetMapping("/signature/petition/{petitionId}")
    public List<signature> findByPetitionId(@PathVariable String petitionId){

        try {
            return signatureService.findByPetitionId(petitionId);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Petition not found", ex);
        }
    }

    @GetMapping("/signature/signer/{signerId}/petition/{petitionId}")
    public Optional<signature> findByUserIdAndPetitionId(@PathVariable String signerId, @PathVariable String petitionId){
        try {
            return signatureService.findBySignerIdAndPetitionId(signerId, petitionId);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Signature not found", ex);
        }
    }
    
    @DeleteMapping("/siganture/{id}")
    public void deleteSignature(@PathVariable String id){
        signatureService.delete(id);
    }
}
