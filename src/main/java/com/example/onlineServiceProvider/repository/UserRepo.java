package com.example.onlineServiceProvider.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlineServiceProvider.entity.base.User;

public interface UserRepo<T extends User> extends JpaRepository<T,Integer> {


}
