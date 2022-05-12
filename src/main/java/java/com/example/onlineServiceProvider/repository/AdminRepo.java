package java.com.example.onlineServiceProvider.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import java.com.example.onlineServiceProvider.entity.user.Admin;


public interface AdminRepo extends JpaRepository<Admin,Integer>{


}
