package com.SocioMediaUser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocioGlobalExceptionHandler {


    @ExceptionHandler(UserNameModificationException.class)
    public ResponseEntity<Object> userNameModificationExceptionMethod(UserNameModificationException userNameModificationException) {
        return new ResponseEntity<>(userNameModificationException, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UserNameNotPresentException.class)
    public ResponseEntity<Object> userNameNotPresentExceptionMethod(UserNameNotPresentException userNameNotPresentException) {
        return new ResponseEntity<>(userNameNotPresentException, HttpStatus.BAD_REQUEST);
    }

}
