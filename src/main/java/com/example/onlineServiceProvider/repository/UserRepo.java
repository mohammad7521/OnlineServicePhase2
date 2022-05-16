package com.example.onlineServiceProvider.repository;


import com.example.onlineServiceProvider.entity.base.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo<T extends User> extends JpaRepository<T,Integer> {


}
