package com.koo9.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.koo9.myspringboot.listener.MyStartingMyListener;

@SpringBootApplication
public class MyspringbootApplication {

	public static void main(String[] args) {
//		SpringApplication.run(MyspringbootApplication.class, args);
		
		//WebApplication Type 변경 
		SpringApplication application = new SpringApplication(MyspringbootApplication.class);
		//Default WebApplication Type이 SERVLET - > NONE (Web이 아닌것) 
		application.setWebApplicationType(WebApplicationType.SERVLET);
//		application.setWebApplicationType(WebApplicationType.NONE);
		
		//Listener 객체 등록 
		application.addListeners(new MyStartingMyListener());
		application.run(args);
	}

}
