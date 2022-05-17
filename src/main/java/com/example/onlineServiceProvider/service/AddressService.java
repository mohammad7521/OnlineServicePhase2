package com.example.onlineServiceProvider.service;


import com.example.onlineServiceProvider.entity.user.Address;

public interface AddressService {

    void add(Address address);

    void remove(Address address);

    void update(Address address);
}
