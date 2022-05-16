package com.example.onlineServiceProvider.entity.c_service;

import lombok.*;

import javax.persistence.*;
import com.example.onlineServiceProvider.entity.base.BaseEntity;
import com.example.onlineServiceProvider.entity.user.Expert;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "Service")
@Table(name = "service")

//services that can be provided by experts
public class C_Service extends BaseEntity<Integer> {

    private String name;

    //self referencing in order to have sub-categories of the main Services.
    @OneToMany(mappedBy = "parentCService",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<C_Service> subCServices =new HashSet<>();

    @ManyToOne
    @JoinColumn(name="parent_service",referencedColumnName = "id")
    private C_Service parentCService;

    private double basePrice;

    private String description;

    @ManyToMany
    @JoinTable(name = "service_expert",joinColumns =@JoinColumn(name = "service_Id")
    ,inverseJoinColumns = @JoinColumn(name = "expert_id"))
    private Set<Expert> serviceExperts=new HashSet<>();



    public void addSubCommercialService(C_Service cService){
        subCServices.add(cService);
    }
}
