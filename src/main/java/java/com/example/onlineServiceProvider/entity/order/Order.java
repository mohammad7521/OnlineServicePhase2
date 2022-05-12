package java.com.example.onlineServiceProvider.entity.order;



import java.com.example.onlineServiceProvider.entity.base.BaseEntity;
import java.com.example.onlineServiceProvider.entity.c_service.C_Service;
import lombok.*;

import javax.persistence.*;
import java.com.example.onlineServiceProvider.entity.offer.Offer;
import java.com.example.onlineServiceProvider.entity.user.Address;
import java.com.example.onlineServiceProvider.entity.user.Customer;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "C_Order")
//orders of service that are set by the customer
public class Order extends BaseEntity<Integer> {


    @ManyToOne
    @JoinColumn(name = "order_customer",referencedColumnName = "id")
    private Customer orderCustomer;


    @OneToOne
    private C_Service cService;


    @OneToMany(mappedBy = "offerOrder",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Offer> orderOffers =new HashSet<>();


    //the offer that is finally associated with the customer order.
    @OneToOne(cascade = CascadeType.ALL)
    private Offer chosenOffer;


    @Column(nullable = false)
    private OrderStatus orderStatus;


    //customer price offer for the job
    private double customerPriceOffer;


    //customer description about the job
    private String customerDescription;




    private int score;
    private String comment;

    @OneToOne
    private Address orderAddress;

    private Date orderDate;

    private LocalDateTime startTime;
    private LocalDateTime finishTime;

    @Transient
    private Duration duration;

    public void addoffer(Offer offer){
        orderOffers.add(offer);
    }

    public void removeoffer(Offer offer){
        orderOffers.remove(offer);
    }

}
