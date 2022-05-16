package com.example.onlineServiceProvider.repository;



import com.example.onlineServiceProvider.entity.user.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ExpertRepo extends JpaRepository<Expert,Integer> {


    @Query(value="select * from service_expert where service_id=?1",nativeQuery = true)
    List<Expert> findByExpertCServices(int serviceID);


}
