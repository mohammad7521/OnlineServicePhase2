package com.example.onlineServiceProvider.exception;


//in case two services with the same name are trying to be added

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class DuplicateServiceName extends RuntimeException {
    public DuplicateServiceName() {
    }
}
