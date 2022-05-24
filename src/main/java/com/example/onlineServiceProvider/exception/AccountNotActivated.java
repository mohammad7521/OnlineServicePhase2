package com.example.onlineServiceProvider.exception;


//when the expert's account is not submitted by the admin

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.FORBIDDEN)
public class AccountNotActivated extends RuntimeException{
    public AccountNotActivated() {
    }
}
