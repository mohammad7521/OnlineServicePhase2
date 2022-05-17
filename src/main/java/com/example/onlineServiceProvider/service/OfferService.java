package com.example.onlineServiceProvider.service;




import com.example.onlineServiceProvider.entity.offer.Offer;
import com.example.onlineServiceProvider.entity.order.Order;
import java.util.List;

public interface OfferService {


    void addOffer(Offer offer);

    List<Offer> offerOrderByPrice(Order order);

    List<Offer> offerOrderByScore(Order order);

    void update(Offer offer);
}
