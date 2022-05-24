package com.example.onlineServiceProvider.dto.request.addUpdate;


import lombok.Data;

import java.sql.Date;

@Data
public class OrderSave {

    private int serviceId;
    private int customerId;
    private double orderPrice;
    private String description;
    private String comment;
    private int addressId;
    private Date orderDate;
}
