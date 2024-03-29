package com.example.restfullwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private  static List<User> users = new ArrayList<>();

    private  static int usersCount = 3;
    static {
        users.add(new User(1, "koo1", new Date(), "pass1", "111111-11111"));
        users.add(new User(2, "koo2", new Date(),"pass2", "222222-11111"));
        users.add(new User(3, "koo3", new Date(),"pass3", "33333-11111"));
    }

    public List<User> findAll(){
        return  users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user : users) {
            if(user.getId() == id){
                return  user;
            }
        }
        return  null;
    }

    public  User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return  null;
    }
}
