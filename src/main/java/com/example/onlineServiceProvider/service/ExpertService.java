package com.example.onlineServiceProvider.service;




import com.example.onlineServiceProvider.entity.c_service.C_Service;
import com.example.onlineServiceProvider.entity.order.Order;
import com.example.onlineServiceProvider.entity.user.Expert;
import java.util.List;

public interface ExpertService  {

    //adding a C_Service as services of an expert.
    public void addService(Expert expert, C_Service service);


    //removing a C_Service from services of an expert.
    public void removeService(Expert expert,C_Service service);



    //filtering experts by services.
    public List<Expert> filterByService(C_Service c_service);


    //getting finished orders of an expert from database
    public List<Order> expertOrders(Expert expert);


    //calculating score of the expert based on previous finished orders.
    public int scoreCalculate(Expert expert);


}
