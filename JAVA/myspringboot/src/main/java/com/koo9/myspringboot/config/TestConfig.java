package com.koo9.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfig {
	
	@Bean
	public String hello() {
		return "Test환경에서 사용되는 hello Bean";
	}
}
