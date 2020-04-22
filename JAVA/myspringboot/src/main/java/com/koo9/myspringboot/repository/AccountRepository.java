package com.koo9.myspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koo9.myspringboot.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long >{
	Account findByUsername(String username);
}
