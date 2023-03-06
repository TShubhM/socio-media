package com.SocioMediaUser.exceptions;

public class UserNameModificationException extends RuntimeException {

    private String message;

    public UserNameModificationException(String message) {
        super(message);
    }

    public UserNameModificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
