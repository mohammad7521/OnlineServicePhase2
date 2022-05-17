package com.example.onlineServiceProvider.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.onlineServiceProvider.entity.c_service.C_Service;


public interface C_ServiceRepo extends JpaRepository<C_Service,Integer> {
}
