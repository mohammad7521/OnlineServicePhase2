package com.example.onlineServiceProvider.dto;


import com.example.onlineServiceProvider.entity.base.User;
import lombok.*;

@Data
public class ExpertDto {

    private User user;
    private double balance;
}
