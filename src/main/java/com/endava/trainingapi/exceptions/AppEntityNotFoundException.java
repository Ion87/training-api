package com.endava.trainingapi.exceptions;

public class AppEntityNotFoundException extends RuntimeException {
    public AppEntityNotFoundException() {
    }

    public AppEntityNotFoundException(String message) {
        super(message);
    }
}
