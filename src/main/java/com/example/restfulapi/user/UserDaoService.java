package com.example.restfulapi.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service //또는 @Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;
    static {
        users.add(new User(1,"hailey1",new Date()));
        users.add(new User(2,"hailey2",new Date()));
        users.add(new User(3,"hailey3",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }

        return null;
    }
}
