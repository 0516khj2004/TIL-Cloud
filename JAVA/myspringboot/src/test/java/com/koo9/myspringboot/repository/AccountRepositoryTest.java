package com.koo9.myspringboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

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
		Account existAcct = repository.findByUsername("spring");
		assertThat(existAcct).isNotNull();
		
		Account notExistAcct = repository.findByUsername("test");
		assertThat(notExistAcct).isNull();
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
