package com.example.onlineServiceProvider.dto.request.addUpdate;


import lombok.Data;



@Data
public class CustomerSave {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private int addressId;

}
