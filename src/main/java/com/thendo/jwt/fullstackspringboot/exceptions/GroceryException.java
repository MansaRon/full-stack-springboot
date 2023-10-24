package com.thendo.jwt.fullstackspringboot.exceptions;

public class GroceryException extends RuntimeException {
    private String errorMessage;

    public GroceryException(String message) {
        super(message);
    }
}
