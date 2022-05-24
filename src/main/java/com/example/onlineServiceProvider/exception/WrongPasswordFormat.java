package com.example.onlineServiceProvider.exception;

//in case password is entered in wrong format (not long enough or isn't alphanumeric)

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class WrongPasswordFormat extends RuntimeException{
    public WrongPasswordFormat() {
    }
}
