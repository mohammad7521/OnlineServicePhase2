package com.example.onlineServiceProvider.repository;


import com.example.onlineServiceProvider.entity.offer.Offer;
import com.example.onlineServiceProvider.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OfferRepo extends JpaRepository<Offer,Integer> {


    //order offers by price
    @Query("FROM Offer o WHERE o.offerOrder.Id = :orderId ORDER BY o.offeredPrice desc ")
    List<Offer> orderByPrice(@Param("orderId") Integer orderId);



    //order offers by expert score
    @Query("FROM Offer o WHERE o.offerOrder.Id = :orderId ORDER BY o.offerExpert.overallScore desc ")
    List<Offer> orderByScore(@Param("orderId") Integer orderId);

}
