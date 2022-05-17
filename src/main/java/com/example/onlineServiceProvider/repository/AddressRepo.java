package com.example.onlineServiceProvider.repository;

import com.example.onlineServiceProvider.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
