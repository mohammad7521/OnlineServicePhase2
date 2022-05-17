package com.example.onlineServiceProvider.service.impl;
import com.example.onlineServiceProvider.entity.user.Address;
import com.example.onlineServiceProvider.repository.AddressRepo;
import com.example.onlineServiceProvider.service.AddressService;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepo addressRepo;

    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo=addressRepo;
    }

    @Override
    public void add(Address address) {
        addressRepo.save(address);
    }

    @Override
    public void remove(Address address) {
        addressRepo.delete(address);
    }

    @Override
    public void update(Address address) {
        addressRepo.save(address);
    }
}
