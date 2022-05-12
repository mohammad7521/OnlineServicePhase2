package java.com.example.onlineServiceProvider.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.com.example.onlineServiceProvider.entity.base.BaseEntity;


public interface BaseRepo<T extends BaseEntity,Integer> extends JpaRepository<T,Integer> {


}
