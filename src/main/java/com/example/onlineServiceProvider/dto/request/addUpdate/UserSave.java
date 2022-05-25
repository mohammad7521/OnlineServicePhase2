package com.example.onlineServiceProvider.dto.request.addUpdate;


import lombok.Data;

@Data
public class UserSave {

    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private int addressId;


}
