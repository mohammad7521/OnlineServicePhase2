package com.example.onlineServiceProvider.exception;


//when we try to add duplicate users

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class DuplicateUser extends RuntimeException {
    public DuplicateUser() {
    }

}
