package com.example.onlineServiceProvider.dto.response;


import com.example.onlineServiceProvider.entity.user.Expert;
import lombok.*;

import java.sql.Time;



@Data
@Builder
public class OfferSearchResponse {

    private Expert expert;
    private double offeredPrice;
    private Time duration;
    private Time startTime;
}
