package com.koo9.myspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koo9.myspringboot.entity.Account;
import com.koo9.myspringboot.entity.User;
import com.koo9.myspringboot.entity.Users;
import com.koo9.myspringboot.exception.ResourceNotFoundException;
import com.koo9.myspringboot.repository.AccountRepository;
import com.koo9.myspringboot.repository.UserRepository;

@RestController
public class UserRestController {

	private UserRepository userRepository;
	
	@RequestMapping(value="/users2", produces = {"application/xml"}) 
	public List<User> getUsers2() {
		return userRepository.findAll();
	}

	@RequestMapping(value = "/usersxml", produces = { "application/xml" })
	public Users getUsersXml() {
		Users users = new Users();
		users.setUsers(userRepository.findAll());
		return users;
	}

//
//	@PostMapping("/users")
//	public User create(@RequestBody User user) {
//		return userRepository.save(user);
//	}
//
//	@RequestMapping(value = "/users/{id}")
//	public User getUser(@PathVariable Long id) {
//		return userRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id)); 
//	}
//
//	@RequestMapping(value = "/users", produces = { "application/json" })
//	public List<User> getUsers() {
//		return userRepository.findAll();
//	}
//
//	@DeleteMapping("/users/{id}")  
//	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
//		User user = userRepository.findById(id) 
//				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
//		userRepository.delete(user);    
//		//return ResponseEntity.ok(user);
//		return ResponseEntity.ok().build(); 
//	} 
//	 
//	 @PutMapping("/users/{id}") 
//	 public User updateUser(@PathVariable Long id, @RequestBody User userDetail) { 
//		 User user = userRepository.findById(id) 
//				 .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
//		 user.setName(userDetail.getName());  
//		 user.setEmail(userDetail.getEmail());  
//		 User updatedUser = userRepository.save(user); 
//		 return updatedUser;  
//	 }
}
