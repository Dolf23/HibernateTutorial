package com.javahash.hibernate.Exceptions;

public class UserExistsException extends Exception {
    public UserExistsException(String message){
        super(message);
    }
}
