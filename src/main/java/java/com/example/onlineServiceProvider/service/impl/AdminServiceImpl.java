package java.com.example.onlineServiceProvider.service.impl;
import java.com.example.onlineServiceProvider.repository.AdminRepo;
import java.com.example.onlineServiceProvider.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {


    private AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

}
