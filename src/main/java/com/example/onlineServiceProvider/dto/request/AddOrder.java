package com.example.onlineServiceProvider.dto.request;


import lombok.Data;

@Data
public class AddOrder {

    private double customerPrice;
    private String description;
    private int serviceId;

}
