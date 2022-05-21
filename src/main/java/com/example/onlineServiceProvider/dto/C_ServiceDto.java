package com.example.onlineServiceProvider.dto;


import com.example.onlineServiceProvider.entity.c_service.C_Service;
import lombok.*;

@Data
public class C_ServiceDto {

    private String name;
    private double basePrice;
    private String description;
    private C_Service parentService;
}
