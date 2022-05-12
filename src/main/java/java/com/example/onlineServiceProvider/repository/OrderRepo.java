package java.com.example.onlineServiceProvider.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.com.example.onlineServiceProvider.entity.offer.Offer;
import java.com.example.onlineServiceProvider.entity.order.Order;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Integer> {


    @Query("select a from Offer a where a.offerOrder.Id=?1")
    List<Offer> offerOrders(int orderId);
}
