package java.com.example.onlineServiceProvider.service;




import java.com.example.onlineServiceProvider.entity.offer.Offer;
import java.com.example.onlineServiceProvider.entity.order.Order;
import java.util.List;

public interface OfferService {


    void addOffer(Offer offer);


    List<Order> offerOrders(Offer offer);
}
