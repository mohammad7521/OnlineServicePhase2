package com.example.onlineServiceProvider.controller;


import com.example.onlineServiceProvider.dto.request.addUpdate.OrderSave;
import com.example.onlineServiceProvider.entity.order.Order;
import com.example.onlineServiceProvider.service.OfferService;
import com.example.onlineServiceProvider.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;
    private OfferService offerService;
    private ModelMapper modelMapper;



    //1-add order by customer
    public ResponseEntity<String> save(OrderSave orderSave){
        Order order=modelMapper.map(orderSave, Order.class);
        orderService.addOrder(order);
        return ResponseEntity.ok("order added successfully");
    }


    //5-setting offer as selected by customer
    @PutMapping("/{orderId}/offer/{offerId}")
    public ResponseEntity<String> selectChosenOffer(@PathVariable int orderId,@PathVariable int offerId){
        orderService.selectOfferByCustomer();
    }
}
