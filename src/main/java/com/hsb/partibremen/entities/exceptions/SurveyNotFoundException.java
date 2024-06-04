package com.hsb.partibremen.entities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Survey not found")
public class SurveyNotFoundException extends Exception{
    public SurveyNotFoundException(String message)
    {
        super(message);
    }
}
