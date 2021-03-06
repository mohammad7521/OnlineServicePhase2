package com.example.onlineServiceProvider.service;




import com.example.onlineServiceProvider.dto.request.addUpdate.CustomerSave;
import com.example.onlineServiceProvider.entity.base.User;
import java.util.List;

public interface UserService<T extends User> {

    boolean checkUsername(String username);

    boolean passwordMinCheck(String password);

    void changePassword(T t,String password);

    List<User> filterUsers(User user);

    void add(T t);

    void remove(T t);

    void update(T t);

    boolean checkEmail(String email);

    User findByID(int id);

    User findByUsername(String username);

    User findByEmail(String email);

}
