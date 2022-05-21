package com.example.onlineServiceProvider.dto;


import com.example.onlineServiceProvider.entity.base.User;
import lombok.*;

@Data
public class CustomerDto {

    private User user;
    private double balance;
}
