package java.com.example.onlineServiceProvider.entity.user;



import java.com.example.onlineServiceProvider.entity.base.User;
import java.com.example.onlineServiceProvider.entity.c_service.C_Service;
import java.com.example.onlineServiceProvider.entity.offer.Offer;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@DiscriminatorValue("3")
public class Expert extends User {


    private SignUpStatus signUpStatus;
    private String photoAddress;
    private int overallScore;

    //each expert can provide as many services as they like.
    @ManyToMany(mappedBy = "serviceExperts",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<C_Service> expertCServices = new HashSet<>();

    @OneToMany(mappedBy = "offerExpert",fetch = FetchType.EAGER)
    private Set<Offer> expertOffers = new HashSet<>();

    private double balance;

    public void addExpertCommercialService (C_Service cService){
        expertCServices.add(cService);
        cService.getServiceExperts().add(this);
    }

    public void removeExpertCommercialService(C_Service cService){
        expertCServices.remove(cService);
        cService.getServiceExperts().remove(this);
    }

    public void addPhotoAddress(String photoAddress){
        this.photoAddress=photoAddress;
    }
}
