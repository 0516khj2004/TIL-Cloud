package myspring.di.xml.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {
	BeanFactory factory;
	
	@Before
	public void init() {
		// 1. spring bean container 생성
		//resourceLocations = spring Bean Config xml 정보를 설정 
		factory = new GenericXmlApplicationContext("config/spring_beans.xml");		
	}
	
	@Test
	public void hello() {
		//2. Container에게 hello bean을 요청 
		Hello hello = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
		//2.1 assertSame(a, b); 메서드를 사용해서 주소 비교
		assertSame(hello, hello2); // 주소가 같은면 test가 통과한다.
		//2.2 Assert.assertEquals() 메서드를 사용해서 값을 비교
		assertEquals("Hello 스프링", hello.sayHello());
		
		hello.print();
		//3. Container에게 StringPrinter bean을 요청 
		Printer sPrinter = factory.getBean("sPrinter",Printer.class);
		assertEquals("Hello 스프링", sPrinter.toString());
		
	}
}
