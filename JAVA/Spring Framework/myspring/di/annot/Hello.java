package myspring.di.annot;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloA")
public class Hello {
	//<property name="name"  value="스프링"/> 
	@Value("${name}")
	String name;
	
	//<property name="printer" ref="stringPrinter" />
	//@Resource(name = "${myprinter}") = 리소스는 지원함 
	//@Qualifier("${myprinter}") = 지원하지 않음 
	@Autowired
	@Qualifier("stringPrinter")
	Printer printer;
	
	List<String> names;
	Map<String, Integer> ages;

	public Hello() {
		System.out.println("hello default constructor called...");
	}

	public Hello(String name, Printer printer) {
		System.out.println("overloading hello constructor called...");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

//	public void setName(String name) {
//		System.out.println("hello setName() called.." + name);
//		this.name = name;
//	}
//
//	public void setPrinter(Printer printer) {
//		System.out.println("hello setPrinter() called.." + printer.getClass().getName());
//		this.printer = printer;
//	}
	
	public void setAges(Map<String, Integer> ages) {
		this.ages = ages;
	}
	
	public Map<String, Integer> getAges() {
		return ages;
	}
	
	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
