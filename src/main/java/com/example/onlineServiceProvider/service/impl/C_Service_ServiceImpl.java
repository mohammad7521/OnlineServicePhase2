package com.example.onlineServiceProvider.service.impl;

import com.example.onlineServiceProvider.repository.C_ServiceRepo;
import com.example.onlineServiceProvider.service.C_Service_Service;
import org.springframework.stereotype.Service;


@Service
public class C_Service_ServiceImpl implements C_Service_Service {


    private C_ServiceRepo c_serviceRepo;

    public C_Service_ServiceImpl(C_ServiceRepo c_serviceRepo) {
        this.c_serviceRepo = c_serviceRepo;
    }
}
