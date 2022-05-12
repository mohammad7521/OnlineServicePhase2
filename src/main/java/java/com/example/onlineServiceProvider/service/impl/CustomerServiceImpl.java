package java.com.example.onlineServiceProvider.service.impl;

import java.com.example.onlineServiceProvider.repository.CustomerRepo;
import java.com.example.onlineServiceProvider.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
}
