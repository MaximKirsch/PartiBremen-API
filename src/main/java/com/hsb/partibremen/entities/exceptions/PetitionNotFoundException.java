package com.hsb.partibremen.entities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Petition not found")
public class PetitionNotFoundException extends Exception{
    public PetitionNotFoundException(String message){
        super(message);
    }
}
