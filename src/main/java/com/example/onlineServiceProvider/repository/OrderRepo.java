package com.example.onlineServiceProvider.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.onlineServiceProvider.entity.order.Order;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Integer> {


    //getting finished orders of an expert from db
    @Query("FROM Order o WHERE o.chosenOffer.offerExpert.Id = :expertId and o.orderStatus>=4")
    List<Order> expertOrders(int expertId);
}
