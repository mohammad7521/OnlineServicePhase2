package com.example.onlineServiceProvider.service.impl;
import com.example.onlineServiceProvider.repository.AdminRepo;
import com.example.onlineServiceProvider.service.AdminService;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {


    private AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

}
