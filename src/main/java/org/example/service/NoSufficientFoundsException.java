package org.example.service;

public class NoSufficientFoundsException extends RuntimeException {
    public NoSufficientFoundsException(String message){
        super(message);
    }
}
