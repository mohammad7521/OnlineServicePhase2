package com.example.onlineServiceProvider.exception;

//when customer doesn't have enough balance

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class LowBalance extends RuntimeException{
    public LowBalance() {
    }
}
