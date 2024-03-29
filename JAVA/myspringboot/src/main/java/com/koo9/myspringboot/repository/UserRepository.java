package com.koo9.myspringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koo9.myspringboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	 Optional<User> findByName(String name);
}
