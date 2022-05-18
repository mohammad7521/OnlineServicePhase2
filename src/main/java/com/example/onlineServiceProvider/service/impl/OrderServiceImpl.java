package com.example.onlineServiceProvider.service.impl;

import com.example.onlineServiceProvider.entity.offer.Offer;
import com.example.onlineServiceProvider.entity.order.Order;
import com.example.onlineServiceProvider.entity.order.OrderStatus;
import com.example.onlineServiceProvider.exception.*;
import com.example.onlineServiceProvider.repository.OfferRepo;
import com.example.onlineServiceProvider.repository.OrderRepo;
import com.example.onlineServiceProvider.service.ExpertService;
import com.example.onlineServiceProvider.service.OfferService;
import com.example.onlineServiceProvider.service.OrderService;
import com.example.onlineServiceProvider.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {



    private OfferService offerService;
    private OrderRepo orderRepo;
    private ExpertService expertService;
    private UserService userService;


    public OrderServiceImpl(OrderRepo orderRepo,OfferService offerService
    ,ExpertService expertService,UserService userService) {
        this.orderRepo = orderRepo;
        this.offerService=offerService;
        this.expertService=expertService;
        this.userService=userService;
    }



    //1
    //adding order by customer
    @Override
    public void addOrder(Order order){
        if (order.getOrderStatus()==null || order.getOrderCustomer()==null
                ||order.getOrderAddress()==null ||order.getOrderDate()==null){
            throw new FillRequirements();
        }
        if (order.getCustomerPriceOffer()<order.getOrderService()
                .getBasePrice())
            throw new LowPrice();
        else

            order.setOrderStatus(OrderStatus.WAITING_FOR_EXPERT_OFFERS);
        Date date=new Date(System.currentTimeMillis());
        Time time=new Time(System.currentTimeMillis());
        order.setDate(date);
        order.setTime(time);
        orderRepo.save(order);
    }


    //5
    //setting an offer as selected by the user
    @Override
    @Transactional
    public void selectOfferByCustomer(Order order, Offer offer) {
        if (offer.getOfferOrder().getId()==order.getId()) {
            if (order.getOrderCustomer().getBalance() >= offer.getOfferedPrice()) {
                order.setChosenOffer(offer);
                order.setCustomerPriceOffer(offer.getOfferedPrice());
                orderRepo.save(order);
                offer.setSelected(true);
                offerService.update(offer);
            } else throw new LowBalance();
        }else throw new WrongOffer();
    }


    //6
    //expert accepting an offer then the expert is on their way
    @Override
    @Transactional
    public void orderSelectByExpert(Order order) {
        if (order.getChosenOffer().isSelected()) {
            order.setOrderStatus(OrderStatus.EXPERT_ON_WAY);
            order.getChosenOffer().setAccepted(true);
            orderRepo.save(order);
            offerService.update(order.getChosenOffer());
        }
    }


    //7
    //expert starting the order
    @Override
    @Transactional
    public void orderStart(Order order) {
        if (order.getOrderStatus()==OrderStatus.EXPERT_ON_WAY) {
            order.setOrderStatus(OrderStatus.STARTED);

            LocalDateTime startTime=LocalDateTime.now();

            order.setStartTime(startTime);

            orderRepo.save(order);

            offerService.update(order.getChosenOffer());
        }
    }



    //8
    //order being finished
    @Override
    @Transactional
    public void orderFinish(Order order, int score) {
        if (score>5 || score<1){
            throw new WrongScore();
        }
        if (order.getOrderStatus()==OrderStatus.STARTED) {
            order.setOrderStatus(OrderStatus.DONE);

            LocalDateTime finishTime=LocalDateTime.now();
            order.setFinishTime(finishTime);
            order.setDuration(Duration.between(order.getStartTime(),finishTime));

            var customer=order.getOrderCustomer();
            var offer=order.getChosenOffer();
            var expert=offer.getOfferExpert();

            order.setDuration(Duration.between(order.getStartTime(),finishTime));
            customer.setBalance(customer.getBalance()-offer.getOfferedPrice());
            expert.setBalance(expert.getBalance()+offer.getOfferedPrice());

            order.setOrderStatus(OrderStatus.PAID);
            order.setScore(score);

            userService.update(expert);
            userService.update(customer);
            orderRepo.save(order);
            offerService.update(offer);
            expertService.scoreCalculate(expert);

        }
    }



}
