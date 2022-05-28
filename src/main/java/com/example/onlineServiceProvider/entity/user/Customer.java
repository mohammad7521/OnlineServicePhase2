package com.example.onlineServiceProvider.entity.user;



import com.example.onlineServiceProvider.entity.base.User;
import com.example.onlineServiceProvider.entity.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@DiscriminatorValue("2")
public class Customer extends User {


    //each customer can have as many addresses as they want.
    @OneToMany(mappedBy = "addressCustomer",fetch = FetchType.EAGER)
    private Set<Address> costumerAddress=new HashSet<>();

    //each customer can have as many orders as they want.
    @OneToMany(mappedBy = "orderCustomer",fetch = FetchType.EAGER)
    private Set<Order> customerOrders =new HashSet<>();


    //customer balance
    private double balance;

    public void addAddress(Address address){
        costumerAddress.add(address);
    }

    public void removeAddress(Address address){
        costumerAddress.remove(address);
    }
}
