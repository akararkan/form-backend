package com.ak_meer.form_app.exceptions;

public class UserNotVerifiedException extends RuntimeException{
    public UserNotVerifiedException(String message) {
        super(message);
    }
    public UserNotVerifiedException(String message, Throwable cause) {
        super(message, cause);
    }
}
