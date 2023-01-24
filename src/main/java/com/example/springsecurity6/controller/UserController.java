package com.example.springsecurity6.controller;

import com.example.springsecurity6.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    public List<User> users = new ArrayList<>();


    @GetMapping("/users")
    public List<User> users(){

        User user1 = new User();
        user1.setFirstName("Mubin");
        user1.setLastName("UIC");
        user1.setId(1L);

        User user2 = new User();
        user2.setFirstName("Kubin");
        user2.setLastName("KIC");
        user2.setId(2L);

        User user3 = new User();
        user3.setFirstName("Subin");
        user3.setLastName("SIC");
        user3.setId(3L);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        users.add(user);

        return user;

    }
}
