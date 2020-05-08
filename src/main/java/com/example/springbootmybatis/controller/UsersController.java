package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.entity.Users;
import com.example.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    UserService service;

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        List<Users> list = service.getAllUsers();
        return  list;
    }

    @GetMapping("/users/{id}")
    public Users getUsersById(@PathVariable String id){
        Users user = service.getUserById(id);
        return user;
    }
}
