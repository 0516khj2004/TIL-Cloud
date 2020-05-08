package com.example.springbootmybatis.repository;

import com.example.springbootmybatis.entity.Users;
import com.example.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//interface구현체 // db에서 데이터가지고 와서 서비스로직하는 곳
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public List<Users> getAllUsers() {
        return mapper.selectAllUsers();
    }

    @Override
    public Users getUserById(String id) {
        return mapper.selectUserById(id);
    }

    @Override
    public int createUser(Users user) {
        return mapper.insertUser(user);
    }

    @Override
    public int modifyUser(Users user) {
        return mapper.updateUser(user);
    }

    @Override
    public int removeUser(String id) {
        return mapper.deleteUser(id);
    }
}
