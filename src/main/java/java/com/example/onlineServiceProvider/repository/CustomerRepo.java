package java.com.example.onlineServiceProvider.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import java.com.example.onlineServiceProvider.entity.user.Customer;


public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
