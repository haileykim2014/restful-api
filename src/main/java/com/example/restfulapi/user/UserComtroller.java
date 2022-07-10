package com.example.restfulapi.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){//RequestBody형식으로 데이터를 받는다.
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
