package java.com.example.onlineServiceProvider.entity.offer;




import java.com.example.onlineServiceProvider.entity.base.BaseEntity;
import java.com.example.onlineServiceProvider.entity.order.Order;
import lombok.*;

import javax.persistence.*;
import java.com.example.onlineServiceProvider.entity.user.Expert;
import java.sql.Time;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

//offers that are set to a certain service that is requested by the customer
public class Offer extends BaseEntity<Integer> {

    //each offer is mapped to only one expert.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "offer_expert",referencedColumnName = "id")
    private Expert offerExpert;

//    //each offer is associated with a service that is provided by the expert.
//    @OneToOne
//    private Service offerService;

    @ManyToOne
    @JoinColumn(name = "offer_order",referencedColumnName = "id")
    private Order offerOrder;


    //price that is offered for the specified service by the expert.
    private double offeredPrice;


    //expert telling customer how long it takes to finish the job.
    private Time duration;

    //expert telling the customer when they can start the job.
    private Time startTime;

    //it is selected by the customer as the favorite offer
    private boolean isSelected;

    //it is accepted by the expert
    private boolean isAccepted;

    public void removeExpert(){
        setOfferExpert(null);
    }
    public void changeExpert(Expert newExpert){
        setOfferExpert(newExpert);
    }

    public void removeOrder(){
        setOfferOrder(null);
    }

    public void changeOrder(Order newOrder){
        setOfferOrder(newOrder);
    }
}
