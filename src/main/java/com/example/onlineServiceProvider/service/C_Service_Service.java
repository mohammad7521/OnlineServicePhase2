package com.example.onlineServiceProvider.service;


import com.example.onlineServiceProvider.entity.c_service.C_Service;
import com.example.onlineServiceProvider.entity.user.Expert;

import java.util.List;

public interface C_Service_Service {

    void add(C_Service service);

    void remove(C_Service service);

    void update(C_Service service);

    List<Expert> serviceExperts(C_Service service);
}
