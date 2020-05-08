package com.example.springbootmybatis.repository;

import com.example.springbootmybatis.entity.Posts;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostMapper {
    List<Posts> AllPosts();
    List<Posts> UserPosts(String user_id);
    Posts DetailPosts(int id);
    Posts insertPost(Posts post);
    Posts deletePost(int id);

}
