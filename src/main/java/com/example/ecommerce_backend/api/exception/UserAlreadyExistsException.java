package com.example.ecommerce_backend.api.exception;

import com.example.ecommerce_backend.model.User;

import java.util.Optional;

public class UserAlreadyExistsException extends Exception{

    public UserAlreadyExistsException(String message){
        super(message);
    }
}
