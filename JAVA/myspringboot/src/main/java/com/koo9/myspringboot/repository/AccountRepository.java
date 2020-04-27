package com.koo9.myspringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koo9.myspringboot.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long >{
	Optional<Account> findByUsername(String username);
}
