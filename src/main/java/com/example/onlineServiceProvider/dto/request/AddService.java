package com.example.onlineServiceProvider.dto.request;


import com.example.onlineServiceProvider.entity.c_service.C_Service;
import lombok.*;

@Data
public class AddService {

    private String name;
    private double basePrice;
    private String description;
    private int parentServiceId;

}
