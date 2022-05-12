package java.com.example.onlineServiceProvider.service.impl;

import com.example.onlineServiceProvider.entity.base.User;
import java.com.example.onlineServiceProvider.repository.UserRepo;
import java.com.example.onlineServiceProvider.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


public class UserServiceImpl<T extends User> implements UserService<T> {

    private UserRepo userRepo;
    private BaseServiceImpl<User> baseService;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public boolean checkUsername(String username) {
        boolean flag=false;
        List<T> userList=userRepo.findAll();

        for (T t:userList){
            if (username.equals(t.getUsername())){
                flag=true;
                break;
            }
        }
        return flag;
    }


    @Override
    public boolean passwordMinCheck(String password){
        boolean flag=false;
        char[] chars = password.toCharArray();
        if (chars.length >= 8) {
            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i]))
                    break;
            }
            for (int i = 0; i < chars.length; i++) {
                if (Character.isLetter(chars[i])) {
                    flag=true;
                }
            }
        }
        return flag;
    }


    @Override
    @Transactional
    public void changePassword(T t, String password) {
        if(passwordMinCheck(password)){
            t.setPassword(password);
            userRepo.save(t);
        }
    }


    //filter users by criteria
    @Override
    public List<User> filterUsers(User user) {
        List<User> userList=baseService.findAll();
        List<User> outPut;
        List<User> filterByFirstName;
        List<User> filterByLastName;
        List<User> filterByUsername;


        outPut=userList.stream().filter((type)->type.getDiscriminatorValue()==user.getDiscriminatorValue())
                .collect(Collectors.toList());

        if(user.getFirstname()!=null){
            filterByFirstName=outPut.stream().filter((f)->f.getFirstname().startsWith(user.getFirstname()))
                    .collect(Collectors.toList());
        }else filterByFirstName=outPut;

        if (user.getLastname()!=null){
            filterByLastName=filterByFirstName.stream().filter((l)->l.getLastname().startsWith(user.getLastname()))
                    .collect(Collectors.toList());
        }else filterByLastName=filterByFirstName;

        if (user.getEmail()!=null){
            filterByUsername=filterByLastName.stream().filter((u)->u.getUsername().startsWith(user.getUsername()))
                    .collect(Collectors.toList());;
        }else filterByUsername=filterByLastName;

        return filterByUsername;
    }
}
