package com.example.onlineServiceProvider.service.impl;

import com.example.onlineServiceProvider.entity.c_service.C_Service;
import com.example.onlineServiceProvider.entity.order.Order;
import com.example.onlineServiceProvider.entity.user.Expert;
import com.example.onlineServiceProvider.repository.ExpertRepo;
import com.example.onlineServiceProvider.repository.OrderRepo;
import com.example.onlineServiceProvider.service.ExpertService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ExpertServiceImpl implements ExpertService {


    private ExpertRepo expertRepo;
    private OrderRepo orderRepo;

    public ExpertServiceImpl(ExpertRepo expertRepo,OrderRepo orderRepo) {
        this.expertRepo = expertRepo;
        this.orderRepo=orderRepo;
    }


    @Override
    @Transactional
    public void addService(Expert expert, C_Service service) {
        expert.addExpertCommercialService(service);
        expertRepo.save(expert);
    }

    @Override
    @Transactional
    public void removeService(Expert expert, C_Service service) {
        expert.removeExpertCommercialService(service);
        expertRepo.save(expert);
    }

    @Override
    @Transactional
    public List<Expert> filterByService(C_Service service) {
        return expertRepo.findByExpertCServices(service.getId());
    }

    @Override
    public List<Order> expertOrders(Expert expert) {
        return orderRepo.expertOrders(expert.getId());
    }

    @Override
    public int scoreCalculate(Expert expert) {
        int score=0;
        int average=0;
        List<Order> finishedOrders=expertOrders(expert);

        for (Order o:finishedOrders){
            score+=o.getScore();
        }
        average=score/finishedOrders.size();
        return average;
    }



}
