package com.example.onlineServiceProvider.controller;


import com.example.onlineServiceProvider.dto.request.addUpdate.OfferSave;
import com.example.onlineServiceProvider.dto.response.OfferSearchResponse;
import com.example.onlineServiceProvider.entity.offer.Offer;
import com.example.onlineServiceProvider.service.OfferService;
import com.example.onlineServiceProvider.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/offer")
public class OfferController {

    private OfferService offerService;
    private OrderService orderService;
    private ModelMapper modelMapper;

    public OfferController(OfferService offerService, OrderService orderService) {
        this.offerService = offerService;
        this.orderService = orderService;
    }


    //2-add offer by expert
    @PostMapping
    public ResponseEntity<String> save(OfferSave offerSave){
        Offer offer=modelMapper.map(offerSave,Offer.class);
        offerService.addOffer(offer);
        return ResponseEntity.ok("offer added successfully");
    }


    @GetMapping("/order/{orderId}")
    public ResponseEntity<Page<OfferSearchResponse>> offerListByPrice(@PathVariable int orderId){
        Page<Offer> offers = offerService.offerOrderByPrice(orderId);

        return ResponseEntity.ok(offers.map(this::createOfferFindByOrderResponse));
    }



//    @GetMapping("/order/{orderId}")
//    public ResponseEntity<Page<OfferSearchResponse>> offerListByScore(@PathVariable int orderId){
//        Page<Offer> offers = offerService.offerOrderByScore(orderId);
//
//        return ResponseEntity.ok(offers.map(this::createOfferFindByOrderResponse));
//    }




    private OfferSearchResponse createOfferFindByOrderResponse(Offer offer) {
        return OfferSearchResponse.builder()
                .expert(offer.getOfferExpert())
                .offeredPrice(offer.getOfferedPrice())
                .startTime(offer.getStartTime())
                .duration(offer.getDuration())
                .build();
    }
}
