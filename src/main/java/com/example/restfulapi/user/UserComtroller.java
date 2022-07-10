package com.example.restfulapi.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserComtroller {
    private UserDaoService service;

    public UserComtroller(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> reetrieveAllUsers(){
        return service.findAll();
    }

    //GET /users/1 or /users/10
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }

}
