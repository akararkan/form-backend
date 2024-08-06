package com.ak_meer.form_app.exceptions;


public class JwtTokenMalformedException extends RuntimeException {
    public JwtTokenMalformedException(String message) {
        super(message);
    }

    public JwtTokenMalformedException(String message, Throwable cause) {
        super(message, cause);
    }
}