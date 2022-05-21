package com.example.onlineServiceProvider.controller;


import com.example.onlineServiceProvider.dto.OfferDto;
import com.example.onlineServiceProvider.entity.order.Order;
import com.example.onlineServiceProvider.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OfferService offerService;

    public OfferController(OfferService offerService){
        super();
        this.offerService=offerService;
    }

    @GetMapping
    public List<OfferDto> offerByPrice(Order order){
        return offerService.offerOrderByPrice(order).stream()
                .map(offer->modelMapper.map(offer,OfferDto.class))
                .collect(Collectors.toList());
    }
}
