package com.example.springbootmybatis.service;

import com.example.springbootmybatis.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();
    Users getUserById(String id);
    int createUser(Users user);
    int modifyUser(Users user);
    int removeUser(String id);
}
