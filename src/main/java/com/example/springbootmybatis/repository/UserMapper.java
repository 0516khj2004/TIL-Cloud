package com.example.springbootmybatis.repository;


import com.example.springbootmybatis.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository //데이터베이스 bean   repository/ service/ component
public interface UserMapper {
    List<Users> selectAllUsers();
    Users selectUserById(String id);
    int insertUser(Users user);
    int updateUser(Users user);
    int deleteUser(String id);
}
