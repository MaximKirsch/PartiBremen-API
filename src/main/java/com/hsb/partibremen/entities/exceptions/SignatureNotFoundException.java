package com.hsb.partibremen.entities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Signature not found")
public class SignatureNotFoundException extends Exception{
    public SignatureNotFoundException(String message){
        super(message);
    }
    
}
