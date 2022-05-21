package com.example.onlineServiceProvider.dto;


import lombok.*;

import java.sql.Time;


@Data
public class OfferDto {

    private double offeredPrice;
    private Time duration;
    private Time startTime;
}
