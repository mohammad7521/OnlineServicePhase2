package com.example.onlineServiceProvider.repository;


import com.example.onlineServiceProvider.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.onlineServiceProvider.entity.base.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepo<T extends User> extends JpaRepository<T,Integer> {


    //find by username
    @Query("FROM User u WHERE u.username = :username")
    User findByUsername(String username);


    //find by id
    @Query("FROM User u WHERE u.Id = :id")
    User findById(int id);


    //find by email
    @Query("FROM User u WHERE u.email = :email")
    User findByEmail(String email);
}
