package com.schneider.autovermietung.exception;

public class CustomerDoesntExistException extends RuntimeException {
    public CustomerDoesntExistException(String message) {
        super(message);
    }
}