package java.com.example.onlineServiceProvider.service.impl;

import com.example.onlineServiceProvider.entity.offer.Offer;
import com.example.onlineServiceProvider.entity.order.Order;
import com.example.onlineServiceProvider.entity.order.OrderStatus;
import java.com.example.onlineServiceProvider.exception.FillRequirements;
import java.com.example.onlineServiceProvider.exception.LowBalance;
import java.com.example.onlineServiceProvider.exception.LowPrice;
import java.com.example.onlineServiceProvider.exception.WrongOffer;
import java.com.example.onlineServiceProvider.repository.OfferRepo;
import java.com.example.onlineServiceProvider.repository.OrderRepo;
import java.com.example.onlineServiceProvider.service.OfferService;
import java.com.example.onlineServiceProvider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {



    private OfferRepo offerRepo;
    private OrderRepo orderRepo;
    private BaseServiceImpl baseService;
    private OfferService offerService;


    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }



    //1
    //adding order by customer
    @Override
    public void addOrder(Order order){
        if (order.getCService()==null || order.getOrderCustomer()==null
                ||order.getOrderAddress()==null ||order.getOrderDate()==null){
            throw new FillRequirements();
        }
        if (order.getCustomerPriceOffer()<order.getCService()
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





    //3
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
                offerService.addOffer(offer);
            } else throw new LowBalance();
        }else throw new WrongOffer();
    }


    //4
    //expert accepting an offer then the expert is on their way
    @Override
    @Transactional
    public void orderSelectByExpert(Order order) {
        if (order.getChosenOffer().isSelected()) {
            order.setOrderStatus(OrderStatus.EXPERT_ON_WAY);
            order.getChosenOffer().setAccepted(true);
            orderRepo.save(order);
            offerRepo.save(order.getChosenOffer());
        }
    }


    //5
    //expert starting the order
    @Override
    @Transactional
    public void orderStart(Order order) {
//        if (order.getOrderStatus()==OrderStatus.EXPERT_ON_WAY) {
//            order.setOrderStatus(OrderStatus.STARTED);
//
//            LocalDateTime startTime=LocalDateTime.now();
//
//            order.getChosenOffer().setStartTime(startTime);
//            order.setStartTime(startTime);
//
//            orderRepo.update(order);
//
//            commercialOfferService=new CommercialOfferServiceImpl(new CommercialOfferRepoImpl());
//            commercialOfferService.update(order.getChosenCommercialOffer(),CommercialOffer.class);
//        }
    }

    @Override
    @Transactional
    public void orderFinish(Order order, int score) {

    }

    @Override
    public List<Offer> orderOffers(int orderId) {
        return orderRepo.offerOrders(orderId);
    }
}
