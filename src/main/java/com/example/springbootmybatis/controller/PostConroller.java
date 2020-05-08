package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.entity.Posts;
import com.example.springbootmybatis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostConroller {
    @Autowired
    PostService service;

    @GetMapping("/posts")
    public List<Posts> getAllPosts(){
        List<Posts> list = service.AllPosts();
        return list;
    }

    @GetMapping("/posts/{user_id}")
    public List<Posts> getUserPosts(@PathVariable String user_id){
        List<Posts> list = service.UserPosts(user_id);
        return list;
    }

    @PostMapping("/posts")
    public Posts insertPosts(@Valid @RequestBody Posts post){
        Posts posts = service.insertPost(post);
        return posts;
    }
}
