package com.example.onlineServiceProvider.exception;


//in case required fields for user(username,password,email) are not set

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class FillRequirements extends RuntimeException{
    public FillRequirements() {
    }
}
