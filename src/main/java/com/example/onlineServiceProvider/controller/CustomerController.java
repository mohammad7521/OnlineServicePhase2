package com.example.onlineServiceProvider.controller;


import com.example.onlineServiceProvider.dto.request.UserLogin;
import com.example.onlineServiceProvider.dto.request.UserVerify;
import com.example.onlineServiceProvider.dto.request.addUpdate.CustomerSave;
import com.example.onlineServiceProvider.entity.base.User;
import com.example.onlineServiceProvider.entity.user.Customer;
import com.example.onlineServiceProvider.exception.NoSuchUser;
import com.example.onlineServiceProvider.service.CustomerService;
import com.example.onlineServiceProvider.service.UserService;
import com.example.onlineServiceProvider.service.jwt.Jwt;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/customer")
public class CustomerController {

    private UserService userService;
    private final AuthenticationManager manager;
    private ModelMapper modelMapper;
    private Jwt jwt;


    public CustomerController(UserService<Customer> userService, AuthenticationManager manager) {
        this.userService = userService;
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity<String> save(CustomerSave customerSave){

        Customer customer=modelMapper.map(customerSave,Customer.class);
        userService.add(customer);
        return ResponseEntity.ok("verification code sent");
    }



    @PostMapping("/verify")
    public ResponseEntity<String> verify(UserVerify userVerify){

        int verificationCode;
        if (!userService.checkEmail(userVerify.getEmail())) {
            throw new NoSuchUser();
        }
        verificationCode=userService.findByID(userVerify.getId()).getVerificationCode();
        User customer=userService.findByID(userVerify.getId());

        if (verificationCode==userVerify.getVerifyCode()){
            customer.setActivation(true);
        }
        return ResponseEntity.ok("user verified successfully!");
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(UserLogin userLogin){
        String token = getToken(userLogin.getEmail(), userLogin.getPassword());
        User user=userService.findByEmail(userLogin.getEmail());
        return ResponseEntity.ok("login successful");
    }



    private String getToken(String email, String password) {
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (Exception e) {
            throw new NoSuchUser();
        }
        return jwt.generateToken(email);

    }
}
