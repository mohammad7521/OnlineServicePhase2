package com.example.onlineServiceProvider.repository;



import com.example.onlineServiceProvider.entity.c_service.C_Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.onlineServiceProvider.entity.user.Expert;
import java.util.List;


public interface ExpertRepo extends JpaRepository<Expert,Integer> {



    @Query("select e.expertCServices from Expert e where e.Id=:expertId")
    List<C_Service> expertServices(int expertId);

}
