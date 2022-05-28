package com.example.onlineServiceProvider.dto.request.addUpdate;


import com.example.onlineServiceProvider.entity.c_service.C_Service;
import com.example.onlineServiceProvider.entity.user.Customer;
import lombok.Data;

import java.security.Provider;
import java.sql.Date;

@Data
public class OrderSave {

    private C_Service service;
    private Customer customer;
    private double orderPrice;
    private String description;
    private String comment;
    private int addressId;
    private Date orderDate;
}
