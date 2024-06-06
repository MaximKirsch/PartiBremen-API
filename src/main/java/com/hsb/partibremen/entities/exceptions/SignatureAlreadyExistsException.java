package com.hsb.partibremen.entities.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.IM_USED, reason = "Signature already exists")
public class SignatureAlreadyExistsException extends Exception{
    public SignatureAlreadyExistsException(String message){
        super(message);
    }
    
}
