package com.example.restfullwebservice.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa") // 중복되는
public class UserJpaController {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  PostRepository postRepository;

    //사용자 모두 조회
    @GetMapping("/users")
    public List<User> retrieveAllUser(){
        return userRepository.findAll();
    }

    //사용자 개별로 조회
    @GetMapping("/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException(String.format("ID[%s] not found ", id));
        }

        Resource<User> resource = new Resource<>(user.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUser());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }
    //사용자 삭제
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

    //사용자 등록
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //post 확인
    @GetMapping("/users/{id}/posts")
    public  List<Post> retrieveAllPostsByUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException(String.format("ID[%s] not found ", id));
        }
        return user.get().getPosts();
    }

    //post 등록
    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post post){
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new UserNotFoundException(String.format("ID[%s] nod found", id));
        }
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return  ResponseEntity.created(location).build();
    }


}
