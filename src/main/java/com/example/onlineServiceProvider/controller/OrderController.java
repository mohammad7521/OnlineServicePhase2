package com.example.onlineServiceProvider.controller;


import com.example.onlineServiceProvider.dto.OrderDto;
import com.example.onlineServiceProvider.entity.order.Order;
import com.example.onlineServiceProvider.service.OrderService;
import com.example.onlineServiceProvider.service.impl.OrderServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping
    public List<OrderDto> allOrders(){
        return orderServiceImpl.showAll().stream()
                .map(order->modelMapper.map(order,OrderDto.class))
                .collect(Collectors.toList());
    }
}
