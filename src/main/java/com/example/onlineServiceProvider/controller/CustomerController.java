package com.example.onlineServiceProvider.controller;


import com.example.onlineServiceProvider.dto.request.addUpdate.CustomerSave;
import com.example.onlineServiceProvider.entity.user.Customer;
import com.example.onlineServiceProvider.service.CustomerService;
import com.example.onlineServiceProvider.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/customer")
public class CustomerController {

    private UserService<Customer> userService;
    private final AuthenticationManager manager;


    public CustomerController(UserService<Customer> userService, AuthenticationManager manager) {
        this.userService = userService;
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity<String> save(CustomerSave customerSave){
        userService.add();
    }
}
