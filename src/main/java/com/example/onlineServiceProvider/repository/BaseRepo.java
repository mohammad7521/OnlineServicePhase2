package com.example.onlineServiceProvider.repository;


import com.example.onlineServiceProvider.entity.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BaseRepo<T extends BaseEntity,Integer> extends JpaRepository<T,Integer> {


}
