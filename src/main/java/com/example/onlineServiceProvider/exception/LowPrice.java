package com.example.onlineServiceProvider.exception;

//when the customer offers a price lower than the base price of the service

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class LowPrice extends RuntimeException{
    public LowPrice() {
    }
}
