package com.example.onlineServiceProvider.dto.request;


import lombok.Data;

@Data
public class UserVerify {

    private  int id;
    private  String email;
    private  int verifyCode;
}
