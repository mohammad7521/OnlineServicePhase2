package com.example.onlineServiceProvider.repository;


import com.example.onlineServiceProvider.entity.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
