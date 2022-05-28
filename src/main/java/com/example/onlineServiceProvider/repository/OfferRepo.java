package com.example.onlineServiceProvider.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.onlineServiceProvider.entity.offer.Offer;
import java.util.List;
import java.util.Optional;


public interface OfferRepo extends JpaRepository<Offer,Integer> {


    //ordering offers by price
    @Query("FROM Offer o WHERE o.offerOrder.Id = :orderId ORDER BY o.offeredPrice DESC")
    Page<Offer> offerOrderByPrice(int orderId);


    //ordering offers by expert score
    @Query("FROM Offer o where o.offerOrder.Id=:orderId ORDER BY o.offerExpert.overallScore desc")
    Page<Offer> offerOrderByScore(int orderId);




}
