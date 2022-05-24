package com.example.onlineServiceProvider.exception;


//when there is no such account with a given id or username

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class NoSuchUser extends RuntimeException {
    public NoSuchUser() {
    }
}
