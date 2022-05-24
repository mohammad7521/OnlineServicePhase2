package com.example.onlineServiceProvider.dto.request.addUpdate;


import lombok.Data;

@Data
public class ServiceSave {

    private String name;
    private double basePrice;
    private String description;
    private int subServiceId;
    private int parentServiceId;
}
