package com.example.onlineServiceProvider.service.impl;

import com.example.onlineServiceProvider.entity.c_service.C_Service;
import com.example.onlineServiceProvider.entity.user.Expert;
import com.example.onlineServiceProvider.repository.C_ServiceRepo;
import com.example.onlineServiceProvider.service.C_Service_Service;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Service
public class C_Service_ServiceImpl implements C_Service_Service {


    private C_ServiceRepo c_serviceRepo;

    public C_Service_ServiceImpl(C_ServiceRepo c_serviceRepo) {
        this.c_serviceRepo = c_serviceRepo;
    }

    @Override
    public void add(C_Service service) {
        c_serviceRepo.save(service);
    }

    @Override
    public void remove(C_Service service) {

        c_serviceRepo.delete(service);
    }

    @Override
    public void update(C_Service service) {
        service.setDate(new Date(System.currentTimeMillis()));
        service.setTime(new Time(System.currentTimeMillis()));
        c_serviceRepo.save(service);
    }


    @Override
    public List<Expert> serviceExperts(C_Service service) {
        return c_serviceRepo.serviceExperts(service.getId());
    }
}
