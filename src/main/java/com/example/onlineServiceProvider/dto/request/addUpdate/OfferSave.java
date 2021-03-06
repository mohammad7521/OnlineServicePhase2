package com.example.onlineServiceProvider.dto.request.addUpdate;


import com.example.onlineServiceProvider.entity.order.Order;
import com.example.onlineServiceProvider.entity.user.Expert;
import lombok.Data;

import java.sql.Time;


@Data
public class OfferSave {

    private Order order;
    private Expert expert;
    private double offeredPrice;
    private Time duration;
    private Time startTime;

}
