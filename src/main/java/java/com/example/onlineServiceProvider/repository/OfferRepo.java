package java.com.example.onlineServiceProvider.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.com.example.onlineServiceProvider.entity.offer.Offer;
import java.com.example.onlineServiceProvider.entity.order.Order;
import java.util.List;

@Repository
public interface OfferRepo extends JpaRepository<Offer,Integer> {

    @Query("select o from Offer o where o.offerOrder.Id=?1")
    List<Order> offerOrders(int orderId);

}
