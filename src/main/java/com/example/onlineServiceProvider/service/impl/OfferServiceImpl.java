package com.example.onlineServiceProvider.service.impl;
import com.example.onlineServiceProvider.entity.c_service.C_Service;
import com.example.onlineServiceProvider.entity.offer.Offer;
import com.example.onlineServiceProvider.entity.order.Order;
import com.example.onlineServiceProvider.entity.order.OrderStatus;
import com.example.onlineServiceProvider.entity.user.SignUpStatus;
import com.example.onlineServiceProvider.exception.AccountNotActivated;
import com.example.onlineServiceProvider.exception.ExpertNotQualified;
import com.example.onlineServiceProvider.exception.FillRequirements;
import com.example.onlineServiceProvider.repository.OfferRepo;
import com.example.onlineServiceProvider.repository.OrderRepo;
import com.example.onlineServiceProvider.service.OfferService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;



@Service
public class OfferServiceImpl implements OfferService {


    private OfferRepo offerRepo;
    private OrderRepo orderRepo;



    public OfferServiceImpl(OfferRepo offerRepo,OrderRepo orderRepo) {
        this.offerRepo = offerRepo;
        this.orderRepo=orderRepo;
    }


    //2
    //offer added by expert for a specific order
    @Override
    @Transactional
    public void addOffer(Offer offer){
        if (offer.getOfferExpert()==null || offer.getOfferOrder()==null
                || offer.getOfferedPrice()<1){
            throw new FillRequirements();
        }

        //checking if the expert is submitted to add offer
        if (offer.getOfferExpert().getSignUpStatus()!= SignUpStatus.SUBMITTED){
            throw new AccountNotActivated();
        }


//        checking if the expert is eligible to add offer for a certain service
        Set<C_Service> expertC_Service=offer.getOfferExpert().getExpertCServices();
        for (C_Service cs:expertC_Service){
            if (offer.getOfferOrder().getCService().getId()!=cs.getId()){
                throw new ExpertNotQualified();
            }
        }
        Order order=offer.getOfferOrder();
        order.addoffer(offer);
        order.setOrderStatus(OrderStatus.EXPERT_CHOOSING);


        orderRepo.save(order);
        Date date=new Date(System.currentTimeMillis());
        Time time=new Time(System.currentTimeMillis());
        offer.setDate(date);
        offer.setTime(time);
        offerRepo.save(offer);
    }


    //3
    //order offers by price
    @Override
    public List<Offer> orderByPrice(Order order) {
        return offerRepo.orderByPrice(order.getId());
    }



    //4
    //order offers by score
    @Override
    public List<Offer> orderByScore(Order order) {
        return offerRepo.orderByPrice(order.getId());
    }


}
