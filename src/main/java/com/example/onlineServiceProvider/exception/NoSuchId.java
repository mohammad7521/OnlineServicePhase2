package com.example.onlineServiceProvider.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class NoSuchId extends RuntimeException{
    public NoSuchId() {
    }
}
