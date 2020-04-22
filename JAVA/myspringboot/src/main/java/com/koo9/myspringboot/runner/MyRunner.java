package com.koo9.myspringboot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.koo9.myspringboot.property.KooProperty;

@Component
@Order(1) // Runner 클래스 중에서 우선순위가 가장 높다
// java -jar -Dfoo myspringboot-0.0.1-SNAPSHOT.jar --bar
// java -jar myspringboot-0.0.1-SNAPSHOT.jar --koo.name=java  우선순위4
// java -jar myspringboot-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
public class MyRunner implements ApplicationRunner{
	
	@Value("${koo.name}")
	private String name;
	
	@Value("${koo.age}")
	private int age;
	
	@Autowired
	KooProperty property;
	
	@Autowired
	String hello;
	
	private Logger logger = LoggerFactory.getLogger(MyRunner.class);
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.debug(">> hello bean : " + hello);
		
		logger.debug(">> Property Name "  + name );
		logger.debug(">> Property Age "  + age );
		logger.debug(">> Property class Name " + property.getName());
		logger.debug(">> Property class fullName " + property.getFullName());
		
		logger.info("SourceArgs : " + args.getOptionNames());
		logger.info("Program Arguments : " + args.containsOption("bar"));
		logger.info("VM Arguments : " + args.containsOption("foo"));
		
	}
	
}
