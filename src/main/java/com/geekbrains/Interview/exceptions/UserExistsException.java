package com.geekbrains.Interview.exceptions;

public class UserExistsException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String message;

    public UserExistsException(String msg) {
        this.message = msg;
    }
}
