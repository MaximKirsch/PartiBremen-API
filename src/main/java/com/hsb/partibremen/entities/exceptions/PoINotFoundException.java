package com.hsb.partibremen.entities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Point of Interest not found")
public class PoINotFoundException extends Exception {
    public PoINotFoundException(String message) {
        super(message);
    }
}
