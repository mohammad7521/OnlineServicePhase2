package com.example.onlineServiceProvider.dto;


import com.example.onlineServiceProvider.entity.c_service.C_Service;
import com.example.onlineServiceProvider.entity.user.Address;
import lombok.Data;

@Data
public class OrderDto {

    private double customerPriceOffer;
//    private C_Service service;
    private String customerDescription;
    private Address orderAddress;
}
