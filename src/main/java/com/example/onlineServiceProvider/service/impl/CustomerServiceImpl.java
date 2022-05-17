package com.example.onlineServiceProvider.service.impl;

import com.example.onlineServiceProvider.repository.CustomerRepo;
import com.example.onlineServiceProvider.service.CustomerService;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
}
