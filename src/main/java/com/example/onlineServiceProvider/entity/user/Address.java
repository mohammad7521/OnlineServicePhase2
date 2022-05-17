package com.example.onlineServiceProvider.entity.user;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.example.onlineServiceProvider.entity.base.BaseEntity;

@Getter
@Setter
@Entity
public class Address extends BaseEntity<Integer> {

    private String city;
    private String district;
    private String fullAddress;
    private int plaque;

    @ManyToOne
    @JoinColumn(name="customer_id",referencedColumnName = "id")
    private Customer addressCustomer;
}
