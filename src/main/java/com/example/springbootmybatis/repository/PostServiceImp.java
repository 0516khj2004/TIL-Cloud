package com.example.springbootmybatis.repository;

import com.example.springbootmybatis.entity.Posts;
import com.example.springbootmybatis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp  implements PostService {
    @Autowired
    PostMapper mapper;

    @Override
    public List<Posts> AllPosts() {
        return mapper.AllPosts();
    }

    @Override
    public List<Posts> UserPosts(String user_id) {
        return mapper.UserPosts(user_id);
    }

    @Override
    public Posts DetailPosts(int id) {
        return mapper.DetailPosts(id);
    }

    @Override
    public Posts insertPost(Posts post) {
        return mapper.insertPost(post);
    }

    @Override
    public Posts deletePost(int id) {
        return mapper.deletePost(id);
    }
}
