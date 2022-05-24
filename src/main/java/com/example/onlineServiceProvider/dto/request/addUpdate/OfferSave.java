package com.example.onlineServiceProvider.dto.request.addUpdate;


import lombok.Data;

import java.sql.Time;


@Data
public class OfferSave {

    private int orderId;
    private int expertId;
    private double offeredPrice;
    private Time duration;
    private Time startTime;

}
