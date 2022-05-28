package com.example.onlineServiceProvider.dto.request;


import lombok.Data;

@Data
public class AddUser {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String passwordRepeat;

}
