package com.example.onlineServiceProvider.repository;



import com.example.onlineServiceProvider.entity.c_service.C_Service;
import org.springframework.data.jpa.repository.JpaRepository;


public interface C_ServiceRepo extends JpaRepository<C_Service,Integer> {
}
