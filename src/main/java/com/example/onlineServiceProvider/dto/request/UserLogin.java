package com.example.onlineServiceProvider.dto.request;


import lombok.Data;


@Data
public class UserLogin {

    private String email;
    private String password;
    private String passwordReenter;

}
