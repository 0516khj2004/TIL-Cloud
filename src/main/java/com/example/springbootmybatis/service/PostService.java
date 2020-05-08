package com.example.springbootmybatis.service;

import com.example.springbootmybatis.entity.Posts;

import java.util.List;

public interface PostService {
    List<Posts> AllPosts();
    List<Posts> UserPosts(String user_id);
    Posts DetailPosts(int id);
    Posts insertPost(Posts post);
    Posts deletePost(int id);
}
