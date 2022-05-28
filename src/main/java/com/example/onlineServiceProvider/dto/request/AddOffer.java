package com.example.onlineServiceProvider.dto.request;


import lombok.Data;

import java.sql.Time;

@Data
public class AddOffer {

    private double offeredPrice;
    private Time duration;
    private Time startTime;
    private int orderId;

}
