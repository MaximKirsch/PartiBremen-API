package com.hsb.partibremen.entities.exceptions;

public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException() {
        super("Password oder Email falsch");
    }
}
