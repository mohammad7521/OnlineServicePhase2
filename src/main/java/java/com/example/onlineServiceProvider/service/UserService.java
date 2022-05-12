package java.com.example.onlineServiceProvider.service;




import java.com.example.onlineServiceProvider.entity.base.User;
import java.util.List;

public interface UserService<T extends User> {

    boolean checkUsername(String username);

    boolean passwordMinCheck(String password);

    void changePassword(T t,String password);

    List<User> filterUsers(User user);

}
