package com.example.onlineServiceProvider.service;




import com.example.onlineServiceProvider.entity.offer.Offer;
import com.example.onlineServiceProvider.entity.order.Order;
import java.util.List;

public interface OfferService {


    void addOffer(Offer offer);

    List<Offer> orderByPrice(Order order);


    List<Offer> orderByScore(Order order);
}
