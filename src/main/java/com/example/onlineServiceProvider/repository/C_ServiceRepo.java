package com.example.onlineServiceProvider.repository;



import com.example.onlineServiceProvider.entity.user.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.onlineServiceProvider.entity.c_service.C_Service;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface C_ServiceRepo extends JpaRepository<C_Service,Integer> {


    @Query("select s.serviceExperts from C_Service s where s.Id=:serviceId")
    public List<Expert> serviceExperts(int serviceId);
}
