package com.koo9.myspringboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.function.Supplier;

import javax.management.RuntimeErrorException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.koo9.myspringboot.entity.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
	@Autowired
	AccountRepository repository;
	
	@Test
	public void findUsername() throws Exception {
//		Account existAcct = repository.findByUsername("spring");
//		assertThat(existAcct).isNotNull();
//		
//		Account notExistAcct = repository.findByUsername("test");
//		assertThat(notExistAcct).isNull();
		
		Optional<Account> existOpt = repository.findByUsername("spring");
		System.out.println(existOpt.isPresent()); //true
		if(existOpt.isPresent()) {
			Account exAccount = existOpt.get();
			System.out.println(exAccount);
		}
		Account account = existOpt.orElseThrow(() -> new RuntimeException("존재하지 않는 username입니다"));
		System.out.println("존재하는 Account" + account);
		
		Optional<Account> notexistOpt = repository.findByUsername("test");
		System.out.println(existOpt.isPresent()); //false
		//orElseThrow() 의 아규먼트 타임 ? 함수형 인터페이스 (람다식으로 표현 가능 - 추상메서드를 람다식으로) supplier
		//Supplier 의 추상메서드 - T get()
		Account notEAccount = notexistOpt.orElseThrow(() -> new RuntimeException("존재 하지 않는 username입니다"));
		System.out.println(notexistOpt);
		
		//NoSuchElementException이 발생한다.
//		Account notExistAcct = notexistOpt.get();
//		System.out.println(notExistAcct);
		
	}
	
	@Test
	@Ignore
	public void account() throws Exception{
		Account account = new Account();
		account.setUsername("spring");
		account.setPassword("1234");
		
		Account saveAcct = repository.save(account);
		System.out.println(saveAcct);
		assertThat(saveAcct).isNotNull();
		
	}
}
