package com.SocioMediaUser.exceptions;

public class UserNameNotPresentException extends RuntimeException {
    public UserNameNotPresentException(String message) {
        super(message);
    }

    public UserNameNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }
}
