package com.example.onlineServiceProvider.service;




import com.example.onlineServiceProvider.entity.offer.Offer;
import com.example.onlineServiceProvider.entity.order.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OfferService {


    void addOffer(Offer offer);

    Page<Offer> offerOrderByPrice(int orderId);

    Page<Offer> offerOrderByScore(int orderId);

    void update(Offer offer);

    Offer findById(int id);
}
