package myspring.di.annot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.annot.Hello;
import myspring.di.annot.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class HelloAnnotatedBeanSpringTest {
	@Autowired
	@Qualifier("helloA")
	Hello hello;
	
	
	@Autowired
	@Qualifier("stringPrinter")
	Printer printer;
	
	@Test
	public void hello() {
		System.out.println(hello.sayHello());
		hello.print();
		System.out.println(printer.toString());
		
	}
}
