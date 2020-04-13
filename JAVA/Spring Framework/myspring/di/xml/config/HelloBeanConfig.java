package myspring.di.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
public class HelloBeanConfig {
	
	@Bean
	//<bean id="stringPrinter" class="">
	public Printer stringpPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	public Printer consoleePrinter() {
		return new ConsolePrinter();
	}
	@Bean
	@Scope("singleton")
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName("ÄÁÇÇ±×");
		hello.setPrinter(stringpPrinter());
		return hello;
	}
}
