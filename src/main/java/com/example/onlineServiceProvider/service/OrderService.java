package com.example.onlineServiceProvider.service;




import com.example.onlineServiceProvider.entity.offer.Offer;
import com.example.onlineServiceProvider.entity.order.Order;
import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    //selecting an offer as favorite by the customer
    void selectOfferByCustomer(Order order, Offer offer);

    //order being selected by expert
    void orderSelectByExpert(Order order);

    //order start
    void orderStart(Order order);

    //order finish
    void orderFinish(Order order, int score);


}
