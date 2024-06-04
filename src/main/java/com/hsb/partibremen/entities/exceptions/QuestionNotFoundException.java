package com.hsb.partibremen.entities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Question not found")
public class QuestionNotFoundException extends Exception{
    public QuestionNotFoundException(String message)
    {
        super(message);
    }
}
